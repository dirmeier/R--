# R--

[![Project Status](http://www.repostatus.org/badges/latest/concept.svg)](http://www.repostatus.org/#concept)
[![Build Status](https://travis-ci.org/dirmeier/R--.svg?branch=master)](https://travis-ci.org/dirmeier/R--)
[![codecov](https://codecov.io/gh/dirmeier/R--/branch/master/graph/badge.svg)](https://codecov.io/gh/dirmeier/R--)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/14653f9754cb40408ad614b305fb0c5d)](https://www.codacy.com/app/simon-dirmeier/R--?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dirmeier/R--&amp;utm_campaign=Badge_Grade)

> An interpreter for R in C++.

## About

This repository contains a toy implementation of an interpreter for `R` written in `C++` to learn more about
interpreters, lexers/tokenizers, parsers and ASTs. So far the interpreter can do:

* <strike>basic arithmetic</strike>,
* functions,
* data-structures,
* clauses,
* loops.

## Installation and Usage

Clone/download the project and run:

```sh
meson build . && ninja -C build
./build/src/R--
```

This requires you to have `meson` which you cat get from `conda-forge` or `pip`.

## Author

Simon Dirmeier <a href="mailto:sfyrbnd @ pm me">sfyrbnd @ pm me</a>
