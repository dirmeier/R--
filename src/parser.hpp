#ifndef R_PARSER_HPP
#define R_PARSER_HPP

#include <string>

#include <memory>
#include "ast.hpp"
#include "lexer.hpp"
#include "parser.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"
#include "token_category.hpp"

class parser
{
   public:
    parser() : lexer_(), token_()
    {
    }

    void init(const std::string&) const;

    std::unique_ptr<ast> parse() const;

   private:
    std::unique_ptr<ast> expression() const;
    std::unique_ptr<ast> term() const;
    std::unique_ptr<ast> factor() const;

    void eat(const token_category& category) const;

    const lexer lexer_;
    mutable token token_;
};

#endif  // R_PARSER_HPP
