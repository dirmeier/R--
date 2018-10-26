
#ifndef R_BINARY_HPP
#define R_BINARY_HPP

#include "ast.hpp"
#include "token.hpp"
#include "token_category.hpp"

class binary: public ast
{
public:
    binary(ast& lhs, ast& rhs, const token& token):
      lhs_(lhs), rhs_(rhs), token_(token)
    {}

    T traverse()
    {
        int l = static_cast<int>(lhs_.traverse());
        int r = static_cast<int>(rhs_.traverse());
        switch (token_.category())
        {

            case token_category::PLUS:
                return Arithmetic.addition(l, r);
            case token_category::MINUS:
                return Arithmetic.substraction(l, r);
            case token_category::MULT:
                return Arithmetic.multiplication(l, r);
            case token_category::DIV:
                return Arithmetic.division(l, r);
            default:
                throw throw parsing_exception("Could not traverse AST");
        }
    }

private:
    const ast lhs_;
    const ast rhs_;
    const token token_;
};

#endif //R_BINARY_HPP
