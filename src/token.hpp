
#ifndef R_TOKEN_HPP
#define R_TOKEN_HPP

#include "node.hpp"
#include "token_category.hpp"


class token

{
public:
    token() = default;

    token(const token_category& category, const node& value):
      category_(category), node_(value)
    {}

    const token_category& category() const
    {
        return category_;
    }

    const node value() const
    {
        return value_;
    }


private:
    token_category category_;
    node value_;
};


#endif //R_TOKEN_HPP
