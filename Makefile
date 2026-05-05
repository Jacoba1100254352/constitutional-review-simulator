MAIN_SOURCES := $(shell find src/main/java -name '*.java')
TEST_SOURCES := $(shell find src/test/java -name '*.java')
JAVA_RELEASE ?= 21
JAVA_PROPS ?= -Dcourtsim.javaRelease=$(JAVA_RELEASE)
LEGISLATIVE_INPUT ?= data/legislative/simulation-campaign-v21-paper.csv

.PHONY: build run campaign paired-campaign sensitivity-check paper paper-artifacts paper-figures paper-tables paper-check paper-clean paper-word-count test ci clean

build:
	mkdir -p out/main
	javac --release $(JAVA_RELEASE) -d out/main $(MAIN_SOURCES)

run: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main $(ARGS)

campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v0 --runs 120 --cases 80 --seed 20260501 --output-dir reports $(ARGS)

paired-campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v1-paired --runs 120 --cases 80 --seed 20260501 --output-dir reports --legislative-input "$(LEGISLATIVE_INPUT)" $(ARGS)

sensitivity-check: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign sensitivity --runs 80 --cases 80 --seed 20260501 --output-dir reports $(ARGS)

paper-figures:
	python3 paper/scripts/generate_figures.py

paper-tables:
	python3 paper/scripts/generate_tables.py

paper-artifacts: paper-figures paper-tables

paper-check: paper-artifacts
	python3 paper/scripts/check_jlc_format.py

paper: paper-artifacts paper-check
	cd paper && latexmk -pdf -interaction=nonstopmode -halt-on-error -outdir=build main.tex

paper-word-count:
	if command -v texcount >/dev/null 2>&1; then cd paper && texcount -inc -total main.tex; else python3 paper/scripts/word_count.py; fi

paper-clean:
	cd paper && latexmk -C -outdir=build main.tex
	rm -rf paper/build

test: build
	mkdir -p out/test
	javac --release $(JAVA_RELEASE) -cp out/main -d out/test $(TEST_SOURCES)
	java $(JAVA_PROPS) -cp out/main:out/test courtsim.SimulatorTests

ci: test campaign paired-campaign sensitivity-check paper

clean:
	rm -rf out
