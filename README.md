# R--

[![Project Status](http://www.repostatus.org/badges/latest/concept.svg)](http://www.repostatus.org/#concept)
[![Build Status](https://travis-ci.org/dirmeier/R--.svg?branch=master)](https://travis-ci.org/dirmeier/R--)

> An interpreter for R in C++.

![R--](https://github.com/dirmeier/R--/blob/master/_fig/demo.gif "R--")

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
