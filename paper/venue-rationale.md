# Venue Rationale: JLC vs. ACM

The current recommendation is to target the *Journal of Law and Courts* (JLC)
rather than an ACM venue.

## Short Answer

JLC is the better first target because the paper's central contribution is a
law-and-courts contribution: it compares constitutional-review institutions,
judicial independence/accountability, selection and tenure, emergency docket
procedure, constitutional councils, cross-checking courts, overrides, and
compliance. The simulator is computational, but the research question is about
court design.

The Congress Institutional Simulator reasonably used ACM because that paper was
framed as computational mechanism search for collective decision-making,
legislative productivity, compromise, and institutional incentives. That is much
closer to the ACM Collective Intelligence / computational social systems lane.

## Comparison

| Dimension | Journal of Law and Courts | ACM Route |
| --- | --- | --- |
| Primary audience | Law-and-courts scholars, judicial politics, legal institutions, comparative courts | Computing, collective intelligence, HCI/computational social systems, mechanism design |
| Best fit for this paper | Constitutional-review architecture, judicial selection, court power, rights protection, emergency procedures, legitimacy, compliance | Simulation method, reusable tooling, data/visualization pipeline, computational institutional design |
| Template | Cambridge/JLC `cup-journal` template | ACM `acmart` template |
| Review framing | Theoretical and empirical legal-institution scholarship, with rigorous qualitative or quantitative methods | Conference/proceedings contribution to computing or collective intelligence |
| Citation style | Chicago author-date | ACM format; author-year only if configured |
| Figures | Allowed inline near first reference; production may require separate high-resolution files after acceptance | Allowed, but ACM requires accessibility descriptions and TAPS-compatible source |
| Main risk | The paper must speak plainly to law-and-courts readers and avoid looking like only a software artifact | The paper may look domain-misaligned unless reframed heavily around computational methods and collective intelligence |

## Why JLC First

JLC's stated scope includes legal institutions, judicial independence, and the
selection of judges, and it welcomes rigorous qualitative and quantitative
methods. That maps directly onto the current manuscript. The article can make a
substantive claim about constitutional-review design while using the simulator
as the method.

An ACM submission would need a different center of gravity. It would need to
foreground the simulator as a computational method or design-search platform and
make the law/courts material the domain case. That is possible, but it would be
a different paper. The current manuscript is already organized around
constitutional-review design tradeoffs, not around a new computer-science
technique.

## Practical Consequence

Keep this JLC version compact, law-and-courts centered, and visually legible:

- use figures to summarize the model pipeline and major tradeoffs;
- keep code architecture and large generated tables in replication materials;
- describe the score as a diagnostic display aid, not an optimization target;
- foreground institutional mechanisms and constitutional values over software
  implementation details.

If the paper later underperforms at JLC or if the simulator grows into a more
general institutional-design engine, an ACM rewrite can still be prepared from
the same repository. That rewrite should use `acmart`, add ACM CCS concepts, add
ACM accessibility descriptions for every figure, and recast the contribution as
computational institutional design rather than law-and-courts theory.

## Sources Checked

- JLC author instructions and scope: https://www.cambridge.org/core/journals/journal-of-law-and-courts/information/author-instructions/preparing-your-materials
- ACM LaTeX author instructions: https://authors.acm.org/proceedings/production-information/preparing-your-article-with-latex
