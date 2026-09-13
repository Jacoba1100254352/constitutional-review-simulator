MAIN_SOURCES := $(shell find src/main/java -name '*.java')
.DEFAULT_GOAL := build
TEST_SOURCES := $(shell find src/test/java -name '*.java')
JAVA_RELEASE ?= 21
JAVA_PROPS ?= -Dcourtsim.javaRelease=$(JAVA_RELEASE)
LEGISLATIVE_INPUT ?= data/legislative/simulation-campaign-v21-paper.csv
PAPER_TEX := constitutional-review-design-stress-test.tex
PAPER_PDF := constitutional-review-design-stress-test.pdf

.PHONY: build run campaign paired-campaign validation-check validation-miss-report research-data-check empirical-platform-report empirical-platform-check scdb-doctrine-audit scdb-doctrine-audit-check scdb-doctrine-apply-ready scdb-doctrine-apply-audited-values sensitivity-check calibration-build calibration-check promotion-check court-profile-build court-profile-check paper paper-artifacts paper-figures paper-tables paper-supplement-tables paper-check figure-placement-audit paper-clean paper-word-count paper-pdf-check supplement submission-bundle test ci clean

.PHONY: benchmark-preservation-check
.PHONY: historical-protocol-check historical-acquire-development historical-freeze-forecasts historical-forecast-check historical-acquire-test
.PHONY: historical-benchmark historical-benchmark-check historical-scores-check historical-sources
.PHONY: historical-study-inputs historical-study-inputs-check historical-study historical-study-check historical-study-audit historical-study-raw-check
.PHONY: historical-analysis historical-analysis-check historical-analysis-validate historical-analysis-validation-check
.PHONY: historical-replication
.PHONY: paper-historical-tables paper-historical-check

paper-historical-tables:
	python3 paper/scripts/generate_historical_tables.py

paper-historical-check:
	python3 paper/scripts/generate_historical_tables.py --check

historical-replication:
	$(MAKE) historical-study
	$(MAKE) historical-study-audit
	$(MAKE) historical-analysis
	$(MAKE) historical-analysis-validate

historical-analysis: historical-scores-check
	python3 scripts/historical_robustness_analysis.py

historical-analysis-check: historical-scores-check
	python3 scripts/historical_robustness_analysis.py --check

historical-analysis-validate:
	python3 scripts/check_historical_analysis.py

historical-analysis-validation-check:
	python3 scripts/check_historical_analysis.py --check

historical-study-inputs:
	python3 scripts/historical_study.py prepare

historical-study-inputs-check:
	python3 scripts/historical_study.py check-inputs

historical-study: build historical-study-inputs-check
	python3 scripts/historical_study.py run

historical-study-check:
	python3 scripts/historical_study.py check

historical-study-raw-check:
	python3 scripts/check_historical_study_raw.py --check

historical-study-audit:
	python3 scripts/check_historical_study_raw.py

historical-benchmark:
	python3 scripts/build_historical_benchmark.py

historical-benchmark-check:
	python3 scripts/build_historical_benchmark.py --check

historical-scores-check:
	python3 scripts/build_historical_benchmark.py --check-scores

historical-sources:
	python3 scripts/build_historical_benchmark.py --fetch-sources

historical-protocol-check:
	python3 scripts/historical_data.py check-protocol

historical-acquire-development:
	python3 scripts/historical_data.py acquire-development

historical-freeze-forecasts:
	python3 scripts/historical_data.py freeze-forecasts

historical-forecast-check:
	python3 scripts/historical_data.py check-forecasts

historical-acquire-test:
	python3 scripts/historical_data.py acquire-test

build:
	mkdir -p out/main
	javac --release $(JAVA_RELEASE) -d out/main $(MAIN_SOURCES)

benchmark-preservation-check:
	python3 scripts/check_benchmark_preservation.py

run: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main $(ARGS)

campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v0 --runs 120 --cases 80 --seed 20260501 --output-dir reports $(ARGS)
	python3 scripts/check_object_measurement.py reports/constitutional-review-campaign-v0

paired-campaign: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign v1-paired --runs 120 --cases 80 --seed 20260501 --output-dir reports --legislative-input "$(LEGISLATIVE_INPUT)" $(ARGS)
	python3 scripts/check_object_measurement.py reports/constitutional-review-paired-import-v1

validation-check: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign validation --runs 120 --cases 80 --seed 20260501 --output-dir reports $(ARGS)
	python3 scripts/check_object_measurement.py reports/constitutional-review-validation-v1
	python3 scripts/build_validation_miss_report.py
	python3 scripts/build_court_profiles.py --write
	python3 scripts/build_empirical_platform_report.py --write

validation-miss-report:
	python3 scripts/build_validation_miss_report.py

research-data-check:
	python3 scripts/check_research_data_quality.py

empirical-platform-report: research-data-check court-profile-build validation-miss-report
	python3 scripts/build_empirical_platform_report.py --write

empirical-platform-check: research-data-check court-profile-check
	python3 scripts/build_empirical_platform_report.py --check
	python3 scripts/check_empirical_platform_consistency.py

scdb-doctrine-audit:
	python3 scripts/audit_scdb_doctrine_denominators.py --write

scdb-doctrine-audit-check:
	python3 scripts/audit_scdb_doctrine_denominators.py --check

scdb-doctrine-apply-ready:
	python3 scripts/audit_scdb_doctrine_denominators.py --apply-ready-denominators

scdb-doctrine-apply-audited-values:
	python3 scripts/audit_scdb_doctrine_denominators.py --apply-audited-values

sensitivity-check: build
	java $(JAVA_PROPS) -cp out/main courtsim.Main --campaign sensitivity --runs 80 --cases 80 --seed 20260501 --output-dir reports $(ARGS)
	python3 scripts/check_object_measurement.py reports/constitutional-review-sensitivity-v1

calibration-build:
	python3 scripts/build_calibration_targets.py --write

calibration-check:
	python3 scripts/build_calibration_targets.py --check
	python3 scripts/check_calibration_promotions.py

promotion-check:
	python3 scripts/check_calibration_promotions.py

court-profile-build:
	python3 scripts/build_court_profiles.py --write

court-profile-check:
	python3 scripts/build_court_profiles.py --check

paper-figures:
	python3 paper/scripts/generate_figures.py

paper-tables:
	python3 scripts/build_validation_miss_report.py
	python3 paper/scripts/generate_tables.py

paper-supplement-tables:
	python3 paper/scripts/generate_supplement.py

paper-artifacts: paper-figures paper-tables paper-supplement-tables paper-historical-tables

paper-check: paper-artifacts
	python3 paper/scripts/check_jlc_format.py

paper: paper-artifacts paper-check
	cd paper && latexmk -pdf -interaction=nonstopmode -halt-on-error -outdir=build $(PAPER_TEX)
	cp paper/build/$(PAPER_PDF) paper/$(PAPER_PDF)
	python3 paper/scripts/audit_float_placement.py --write

figure-placement-audit:
	python3 paper/scripts/audit_float_placement.py --write

paper-word-count:
	if command -v texcount >/dev/null 2>&1; then cd paper && texcount -inc -total $(PAPER_TEX); else python3 paper/scripts/word_count.py; fi

paper-clean:
	cd paper && latexmk -C -outdir=build $(PAPER_TEX)
	rm -rf paper/build
	rm -rf paper/scripts/__pycache__
	rm -f paper/*.aux paper/*.log paper/*.out paper/*.pdf paper/*.synctex.gz paper/.DS_Store config/.DS_Store

supplement:
	python3 paper/scripts/generate_supplement.py
	python3 paper/scripts/generate_historical_tables.py
	cd paper && latexmk -pdf -interaction=nonstopmode -halt-on-error -outdir=build supplementary-appendix.tex
	cp paper/build/supplementary-appendix.pdf paper/supplementary-appendix.pdf

paper-pdf-check:
	python3 scripts/build_submission_bundle.py --check-pdfs-only

submission-bundle:
	python3 scripts/build_submission_bundle.py

test: build
	mkdir -p out/test
	javac --release $(JAVA_RELEASE) -cp out/main -d out/test $(TEST_SOURCES)
	java $(JAVA_PROPS) -cp out/main:out/test courtsim.SimulatorTests
	python3 -m unittest discover -s scripts -p 'test_*measurement*.py'

ci: calibration-check research-data-check court-profile-check historical-scores-check test campaign paired-campaign validation-check benchmark-preservation-check empirical-platform-check sensitivity-check historical-study-check historical-analysis-check historical-analysis-validation-check paper supplement submission-bundle

clean:
	rm -rf out
