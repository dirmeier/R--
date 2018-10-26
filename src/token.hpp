
#ifndef R_TOKEN_HPP
#define R_TOKEN_HPP

#include <utility>
#include <boost/any.hpp>

#include "node.hpp"
#include "token_category.hpp"


class token

{
public:
    token() = default;

    token(token_category category, boost::any value):
      category_(category), value_(value)
    {}

    const token_category category() const
    {
        return category_;
    }

    const boost::any value() const
    {
        return value_;
    }


private:
    token_category category_;
    boost::any value_;
};


#endif //R_TOKEN_HPP
