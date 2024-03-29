#ifndef R_INTERPRETER_HPP
#define R_INTERPRETER_HPP

#include <iostream>
#include <string>

#include "parser.hpp"
#include "parsing_exception.hpp"

class interpreter
{
   public:
    const static interpreter& instance()
    {
        static thread_local interpreter instance;
        return instance;
    }

    interpreter(interpreter const&) = delete;

    void operator=(interpreter const&) = delete;

    void run() const;

    static const char* DISCLAIMER;

   private:
    std::string interpret(std::string& text) const;

    std::string expression(std::string& text) const;

    interpreter() : parser_()
    {
    }

    parser parser_;
};

#endif  // R_INTERPRETER_HPP
