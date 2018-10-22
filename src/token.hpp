
#ifndef R_TOKEN_HPP
#define R_TOKEN_HPP

#include "token_category.hpp"


class token
{
public:
    template <typename T>
    token(const token_category& category, const T& value)
    {}

    const token_category& category() const
    {
        return category_;
    }

    template <typename T>
    const T value() const
    {
        return value_;
    }


private:
    token_category category_;
    T value_;
};


#endif //R_TOKEN_HPP
