
#ifndef R_UNARY_HPP
#define R_UNARY_HPP

#include <boost/any.hpp>
#include <memory>

#include "ast.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"
#include "token_category.hpp"

class unary: public ast
{
public:

    unary(std::unique_ptr<ast>&& expression, token token):
      expression_(std::move(expression)), token_(token)
    {}

    boost::any traverse()
    {
        int times = -1;
        switch (token_.category())
        {
            case token_category::PLUS:
                times = 1;
                // fallthrough
            case token_category::MINUS:
                return times * boost::any_cast<int>(expression_->traverse());
            default:
                throw parsing_exception("Could not traverse AST");
        }
    }

private:
    std::unique_ptr<ast> expression_;
    token token_;
};

#endif //R_NODE_HPP
