<h1 align="center"> R-- </h1>

[![Project Status](http://www.repostatus.org/badges/latest/wip.svg)](http://www.repostatus.org/#wip)
[![Build Status](https://travis-ci.org/dirmeier/R--.svg?branch=master)](https://travis-ci.org/dirmeier/R--)
[![codecov](https://codecov.io/gh/dirmeier/R--/branch/master/graph/badge.svg)](https://codecov.io/gh/dirmeier/R--)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/14653f9754cb40408ad614b305fb0c5d)](https://www.codacy.com/app/simon-dirmeier/R--?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dirmeier/R--&amp;utm_campaign=Badge_Grade)

An interpreter for R in Java.

![R--](https://github.com/dirmeier/R--/blob/master/_fig/demo.gif "R--")

## Introduction

A toy implementation of an interpreter for `R` written in `Java`. This project is mainly to understand how interpreters, lexers/tokenizers, parsers, ASTs and things like that work exactly. Since `R` and `Java` are the greatest languages of all time, I chose to try it on these. However the lexer of course can translate to any language. I'll try to cover:

* <strike>basic arithmetic</strike>,
* functions,
* data-structures,
* clauses,
* loops.

So far `R--` is able to substract or add two integers :scream:.

## Installation and Usage

Clone/download the project and run:

```sh
  mvn clean package
  ./R--
```

This of course requires you to have `maven`.

## Author

* Simon Dirmeier <a href="mailto:mail@simon-dirmeier.net">mail@simon-dirmeier.net</a>
