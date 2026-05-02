% Local compatibility layer for the Cambridge/Overleaf cup-journal template.
% The official Journal of Law and Courts template uses \documentclass{cup-journal}.
% This file keeps the repository buildable on TeX installations that do not ship
% Cambridge's class. For final submission, replace this shim with the official
% Overleaf/Cambridge template package if the submission system requires it.
\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{cup-journal}[2026/05/02 Local Cambridge small template compatibility]

\DeclareOption*{}
\ProcessOptions\relax
\LoadClass[11pt]{article}

\RequirePackage[margin=1in]{geometry}
\RequirePackage{fancyhdr}
\RequirePackage{xparse}

\setlength{\headheight}{14pt}
\pagestyle{fancy}
\fancyhf{}
\fancyhead[L]{Journal of Law and Courts target manuscript}
\fancyhead[R]{\thepage}
\renewcommand{\headrulewidth}{0.4pt}

\def\cup@affiliation{}
\def\cup@empty{}

\NewDocumentCommand{\affiliation}{m}{\def\cup@affiliation{#1}}
\NewDocumentCommand{\email}{om}{}
\NewDocumentCommand{\alsoaffiliation}{m}{}
\NewDocumentCommand{\keywords}{m}{\def\@keywords{#1}}
\def\@keywords{}
\NewDocumentCommand{\printendnotes}{}{}
\NewDocumentCommand{\headrow}{m}{\textbf{#1}}

\let\cup@oldmaketitle\maketitle
\renewcommand{\maketitle}{%
  \cup@oldmaketitle
  \ifx\cup@affiliation\cup@empty\else
    \begin{center}\small \cup@affiliation\end{center}
  \fi
  \ifx\@keywords\@empty\else
    \noindent\textbf{Keywords: } \@keywords\par\vspace{1em}
  \fi
}
