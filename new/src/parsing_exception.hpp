/**
 * Author: Simon Dirmeier
 * Date: 21.10.18
 * Email: simon.dirmeier@bsse.ethz.ch
 */

#ifndef R_PARSING_EXCEPTION_HPP
#define R_PARSING_EXCEPTION_HPP

#include <iostream>
#include <exception>

class parsing_exception: public exception
{
public:

    parsing_exception(const char* msg): what(msg)
    parsing_exception(): what("")

    const char* what(const char* what) const throw()
    {
        return what;
    }
private:
    const char* what;
};

#endif //R_PARSING_EXCEPTION_HPP
