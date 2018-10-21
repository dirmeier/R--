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

class parser
{
public:
    parser(): lexer_()
    {}

    void init(const std::string&);

    ast parse();

private:

    ast expression();
    ast term();
    ast factor();

    void eat(const token_category& category);


    const lexer lexer_;
    token token_;
};


#endif //R_PARSER_HPP
