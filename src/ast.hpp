
#ifndef R_AST_HPP
#define R_AST_HPP

#include <boost/any.hpp>

class ast
{
public:
    virtual boost::any traverse() = 0;
};

#endif //R_AST_HPP
