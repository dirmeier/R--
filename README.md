# Python--

[![Project Status](http://www.repostatus.org/badges/latest/concept.svg)](http://www.repostatus.org/#concept)
[![Build Status](https://travis-ci.org/dirmeier/Python--.svg?branch=master)](https://travis-ci.org/dirmeier/Python--)
[![codecov](https://codecov.io/gh/dirmeier/Python--/branch/master/graph/badge.svg)](https://codecov.io/gh/dirmeier/Python--)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/14653f9754cb40408ad614b305fb0c5d)](https://www.codacy.com/app/simon-dirmeier/Python--?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dirmeier/Python--&amp;utm_campaign=Badge_Grade)

> An interpreter for Python in C++.

## About

This repository contains a toy implementation of an interpreter for `Python` written in `C++` to learn more about 
interpreters, lexers/tokenizers, parsers and ASTs. Since `Python` and `C++` are the greatest 
So far the interpreter can do:

* <strike>basic arithmetic</strike>,
* functions,
* data-structures,
* clauses,
* loops.

## Installation and Usage

Clone/download the project and run:

```sh
meson build . && ninja -C build
./build/src/Python--
```

This requires you to have `meson` which you cat get from `conda-forge` or `pip`.

## Author

Simon Dirmeier <a href="mailto:sfyrbnd @ pm me">sfyrbnd @ pm me</a>
