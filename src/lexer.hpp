/**
 * Author: Simon Dirmeier
 * Date: 21.10.18
 * Email: simon.dirmeier@bsse.ethz.ch
 */


#ifndef R_LEXER_HPP
#define R_LEXER_HPP

#include <string>

#include "token.hpp"

class lexer
{
public:
    lexer()
    {}

    void init(const std::string&)  const;
    token next()  const;

private:
    void increment_position()  const;
    int to_int()  const;
    void skip_whitespace()  const;

    static const char END_CHAR;

    mutable std::string text_;
    mutable unsigned int position_;
    mutable char current_char_;
};

#endif //R_LEXER_HPP
