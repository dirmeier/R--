
#ifndef R_BINARY_HPP
#define R_BINARY_HPP

#include <boost/any.hpp>

#include "ast.hpp"
#include "arithmetic.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"
#include "token_category.hpp"

class binary: public ast
{
public:
    binary(ast* lhs,  ast* rhs,  token token):
      lhs_(lhs), rhs_(rhs), token_(token)
    {}

    boost::any traverse()
    {
        int l =  boost::any_cast<int>(lhs_->traverse());
        int r = boost::any_cast<int>(rhs_->traverse());
        switch (token_.category())
        {

            case token_category::PLUS:
                return addition(l, r);
            case token_category::MINUS:
                return substraction(l, r);
            case token_category::MULT:
                return multiplication(l, r);
            case token_category::DIV:
                return division(l, r);
            default:
                throw parsing_exception("Could not traverse AST");
        }
    }

private:
     ast* lhs_;
     ast* rhs_;
     token token_;
};

#endif //R_BINARY_HPP
