/**
 * Author: Simon Dirmeier
 * Date: 21.10.18
 * Email: simon.dirmeier@bsse.ethz.ch
 */


#ifndef R_PARSER_HPP
#define R_PARSER_HPP

#include <string>

#include "ast.hpp"
#include "lexer.hpp"
#include "parser.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"
#include "token_category.hpp"

class parser
{
public:

    parser(): lexer_(), token_()
    {}

    void init(const std::string&) const;

    ast* parse() const;

private:

    ast* expression() const;
    ast* term() const;
    ast* factor() const;

    void eat(const token_category& category) const;

    const lexer lexer_;
    mutable token token_;
};

#endif //R_PARSER_HPP
