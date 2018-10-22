
#ifndef R_UNARY_HPP
#define R_UNARY_HPP

#include "ast.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"

class unary: public ast
{
public:
    template<typename T>
    unary(ast& expr, const token<T>& token):
      token_(token), expression_(expression)
    {}

    T traverse()
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
    template const token<typename T> token_;
};

#endif //R_NODE_HPP
