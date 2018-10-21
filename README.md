# R--

[![Project Status](http://www.repostatus.org/badges/latest/concept.svg)](http://www.repostatus.org/#concept)
[![Build Status](https://travis-ci.org/dirmeier/R--.svg?branch=master)](https://travis-ci.org/dirmeier/R--)
[![codecov](https://codecov.io/gh/dirmeier/R--/branch/master/graph/badge.svg)](https://codecov.io/gh/dirmeier/R--)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/14653f9754cb40408ad614b305fb0c5d)](https://www.codacy.com/app/simon-dirmeier/R--?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dirmeier/R--&amp;utm_campaign=Badge_Grade)

An interpreter for R in C++.

![R--](https://github.com/dirmeier/R--/blob/master/_fig/demo.gif "R--")

## Introduction

This repository contains a toy implementation of an interpreter for `R` written in `C++`. 
The project is mainly to understand how interpreters, lexers/tokenizers, parsers, ASTs and things like that work exactly. 
Since `R` and `C++` are the greatest languages of all time, I chose to try it on these. 
However the lexer of course can translate to any language. So far the interpreter can do:

* <strike>basic arithmetic</strike>,
* functions,
* data-structures,
* clauses,
* loops.

## Installation and Usage

Clone/download the project and run:

```sh
mkdir build && cd build
cmake .. && make
./R--
```

If you want to install `R--` call in addition:

```sh
make install
```

This of course requires you to have `CMake`.

## Author

Simon Dirmeier <a href="mailto:simon.dirmeier@web.de">simon.dirmeier@web.de</a>
