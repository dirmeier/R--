/**
 * Author: Simon Dirmeier
 * Date: 21.10.18
 * Email: simon.dirmeier@bsse.ethz.ch
 */

#ifndef R_INTERPRETER_HPP
#define R_INTERPRETER_HPP

#include <iostream>
#include <string>

#include "parser.hpp"
#include "parsing_exception.hpp"

class interpreter
{
public:
    static interpreter& instance()
    {
        static thread_local interpreter instance;
        return instance;
    }

    interpreter(interpreter const&) = delete;

    void operator=(interpreter const&) = delete;

    void run();

    static const char* DISCLAIMER;

private:
    std::string interpret(std::string& text);

    //interpreter(): parser_(parser::instance(lexer::instance())){};

    interpreter(): parser_() {}

    parser parser_;
};

#endif //R_INTERPRETER_HPP
