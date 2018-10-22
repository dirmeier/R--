
#ifndef R_NUMBERNODE_HPP
#define R_NUMBERNODE_HPP

#include "ast.hpp"
#include "token.hpp"

class number_node: public ast
{
public:
    template<typename T>
    number_node(const token<T>& token): token_(t)
    {}

    T traverse()
    {
        return token_.value();
    }

private:
    const token<T> token_;
};

#endif //R_NUMBERNODE_HPP
