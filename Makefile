MAIN_SOURCES := $(shell find src/main/java -name '*.java')
TEST_SOURCES := $(shell find src/test/java -name '*.java')
JAVA_RELEASE ?= 21
JAVA_PROPS ?= -Dcourtsim.javaRelease=$(JAVA_RELEASE)
LEGISLATIVE_INPUT ?= data/legislative/simulation-campaign-v21-paper.csv

.PHONY: build run campaign paired-campaign validation-check validation-miss-report sensitivity-check calibration-build calibration-check promotion-check paper paper-artifacts paper-figures paper-tables paper-supplement-tables paper-check figure-placement-audit paper-clean paper-word-count paper-pdf-check supplement submission-bundle test ci clean

build:
	mkdir -p out/main
	javac --release $(JAVA_RELEASE) -d out/main $(MAIN_SOURCES)

run: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main $(ARGS)

campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v0 --runs 120 --cases 80 --seed 20260501 --output-dir reports $(ARGS)

paired-campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v1-paired --runs 120 --cases 80 --seed 20260501 --output-dir reports --legislative-input "$(LEGISLATIVE_INPUT)" $(ARGS)

validation-check: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign validation --runs 120 --cases 80 --seed 20260501 --output-dir reports $(ARGS)
	python3 scripts/build_validation_miss_report.py

validation-miss-report:
	python3 scripts/build_validation_miss_report.py

sensitivity-check: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign sensitivity --runs 80 --cases 80 --seed 20260501 --output-dir reports $(ARGS)

calibration-build:
	python3 scripts/build_calibration_targets.py --write

calibration-check:
	python3 scripts/build_calibration_targets.py --check
	python3 scripts/check_calibration_promotions.py

promotion-check:
	python3 scripts/check_calibration_promotions.py

paper-figures:
	python3 paper/scripts/generate_figures.py

paper-tables:
	python3 scripts/build_validation_miss_report.py
	python3 paper/scripts/generate_tables.py

paper-supplement-tables:
	python3 paper/scripts/generate_supplement.py

paper-artifacts: paper-figures paper-tables paper-supplement-tables

paper-check: paper-artifacts
	python3 paper/scripts/check_jlc_format.py

paper: paper-artifacts paper-check
	cd paper && latexmk -pdf -interaction=nonstopmode -halt-on-error -outdir=build main.tex
	cp paper/build/main.pdf paper/main.pdf
	python3 paper/scripts/audit_float_placement.py --write

figure-placement-audit:
	python3 paper/scripts/audit_float_placement.py --write

paper-word-count:
	if command -v texcount >/dev/null 2>&1; then cd paper && texcount -inc -total main.tex; else python3 paper/scripts/word_count.py; fi

paper-clean:
	cd paper && latexmk -C -outdir=build main.tex
	rm -rf paper/build
	rm -rf paper/scripts/__pycache__
	rm -f paper/*.aux paper/*.log paper/*.out paper/*.pdf paper/*.synctex.gz paper/.DS_Store config/.DS_Store

supplement:
	python3 paper/scripts/generate_supplement.py
	cd paper && latexmk -pdf -interaction=nonstopmode -halt-on-error -outdir=build supplementary-appendix.tex

paper-pdf-check:
	python3 scripts/build_submission_bundle.py --check-pdfs-only

submission-bundle:
	python3 scripts/build_submission_bundle.py

test: build
	mkdir -p out/test
	javac --release $(JAVA_RELEASE) -cp out/main -d out/test $(TEST_SOURCES)
	java $(JAVA_PROPS) -cp out/main:out/test courtsim.SimulatorTests

ci: calibration-check test campaign paired-campaign validation-check sensitivity-check paper supplement submission-bundle

clean:
	rm -rf out
