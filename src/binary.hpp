
#ifndef R_BINARY_HPP
#define R_BINARY_HPP

#include <boost/any.hpp>
#include <memory>

#include "ast.hpp"
#include "arithmetic.hpp"
#include "parsing_exception.hpp"
#include "token.hpp"
#include "token_category.hpp"

class binary : public ast
{
   public:
    binary(std::unique_ptr<ast>&& lhs, std::unique_ptr<ast>&& rhs, token token)
        : lhs_(std::move(lhs)), rhs_(std::move(rhs)), token_(token)
    {
    }

    boost::any traverse()
    {
        int l = boost::any_cast<int>(lhs_->traverse());
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
    std::unique_ptr<ast> lhs_;
    std::unique_ptr<ast> rhs_;
    token token_;
};

#endif  // R_BINARY_HPP
