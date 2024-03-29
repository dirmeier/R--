#ifndef R_PARSING_EXCEPTION_HPP
#define R_PARSING_EXCEPTION_HPP

#include <exception>

class parsing_exception : public std::exception
{
   public:
    parsing_exception(const char* msg) : what_(msg)
    {
    }
    parsing_exception() : what_("")
    {
    }

    const char* what() const noexcept
    {
        return what_;
    }

   private:
    const char* what_;
};

#endif  // R_PARSING_EXCEPTION_HPP
