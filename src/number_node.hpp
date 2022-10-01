#ifndef R_NUMBERNODE_HPP
#define R_NUMBERNODE_HPP

#include <boost/any.hpp>

#include "ast.hpp"
#include "token.hpp"

class number_node : public ast
{
   public:
    number_node(token token) : token_(token)
    {
    }

    boost::any traverse()
    {
        return token_.value();
    }

   private:
    token token_;
};

#endif  // R_NUMBERNODE_HPP
