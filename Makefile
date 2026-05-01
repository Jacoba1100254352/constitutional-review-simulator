MAIN_SOURCES := $(shell find src/main/java -name '*.java')
TEST_SOURCES := $(shell find src/test/java -name '*.java')
JAVA_RELEASE ?= 21
JAVA_PROPS ?= -Dcourtsim.javaRelease=$(JAVA_RELEASE)

.PHONY: build run campaign paired-campaign paper paper-clean test ci clean

build:
	mkdir -p out/main
	javac --release $(JAVA_RELEASE) -d out/main $(MAIN_SOURCES)

run: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main $(ARGS)

campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v0 --runs 120 --cases 80 --seed 20260501 --output-dir reports $(ARGS)

paired-campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v1-paired --runs 120 --cases 80 --seed 20260501 --output-dir reports --legislative-input '/Users/jacobanderson/Documents/simulators/Congress Institutional Simulator/reports/simulation-campaign-v21-paper.csv' $(ARGS)

paper:
	cd paper && latexmk -pdf -interaction=nonstopmode -halt-on-error -outdir=build main.tex

paper-clean:
	cd paper && latexmk -C -outdir=build main.tex
	rm -rf paper/build

test: build
	mkdir -p out/test
	javac --release $(JAVA_RELEASE) -cp out/main -d out/test $(TEST_SOURCES)
	java $(JAVA_PROPS) -cp out/main:out/test courtsim.SimulatorTests

ci: test campaign paired-campaign paper

clean:
	rm -rf out
