# Local Template Shim Notice

`paper/cup-journal.cls` is a local compatibility shim used only so the
anonymous review manuscript and supplementary appendix can be rebuilt on this
machine.

It is not the official Cambridge University Press template bundle. Cambridge's
Journal of Law and Courts preparation instructions point LaTeX authors to the
Cambridge small-template Overleaf package. As reviewed on May 9--10, 2026, the
official Overleaf template page identifies the template as "Cambridge Small
Template Class File," lists Journal of Law and Courts among the supported
journals, and uses the `cup-journal` class interface. The official class is not
installed in the local TeX environment; `kpsewhich cup-journal.cls` resolves no
official publisher file unless this repository's local shim is on the build
path.

https://www.overleaf.com/latex/templates/cambridge-small-template-class-file/tcfpmdpjdybn

For PDF-only review submission, the shim is a reproducibility aid. For final
editable source submission, replace it with the official Cambridge template
files exported from Overleaf or obtain editor approval to keep the local shim.
