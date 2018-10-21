/**
 * Author: Simon Dirmeier
 * Date: 21.10.18
 * Email: simon.dirmeier@bsse.ethz.ch
 */

#ifndef R_PARSING_EXCEPTION_HPP
#define R_PARSING_EXCEPTION_HPP

#include <exception>

class parsing_exception: public std::exception
{
public:

    parsing_exception(const char* msg): what_(msg) {}
    parsing_exception(): what_("") {}

    const char* what() const throw()
    {
        return what_;
    }
private:
    const char* what_;
};

#endif //R_PARSING_EXCEPTION_HPP
