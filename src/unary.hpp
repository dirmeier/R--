
#ifndef R_UNARY_HPP
#define R_UNARY_HPP

#include "ast.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"

class unary: public ast
{
public:

    unary(ast& expression, const token& token):
      token_(token), expression_(expression)
    {}

    int traverse()
    {
        int times = -1;
        switch (token_.category())
        {
            case PLUS:
                times = 1;
            case MINUS:
                return times * static_cast<int>(expr_);
            default:
                throw parsing_exception("Could not traverse AST");
        }
    }

private:
    const ast expression_;
    const token token_;
};

#endif //R_NODE_HPP
