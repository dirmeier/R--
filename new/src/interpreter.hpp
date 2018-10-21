/**
 * Author: Simon Dirmeier
 * Date: 21.10.18
 * Email: simon.dirmeier@bsse.ethz.ch
 */

#ifndef R_INTERPRETER_HPP
#define R_INTERPRETER_HPP

#include <string>
#include <iostream>

static const char* DISCLAIMER =
  "\nWelcome to R-- v0.1 ('It's Alive').\n\n" \
  "R-- is a slower, experimental implementation of R in C++.\n" \
  "Be aware of bugs and minimal functionality.\n" \
  "If you are brave enough you can contribute.\n\n" \
  "Ctrl+C to quit! Good luck.\n\n";

class interpreter
{
public:
    static interpreter& instance()
    {
        static thread_local interpreter instance;
        return instance;
    }

    interpreter(interpreter const&) = delete;
    void operator=(interpreter const&) = delete;

    void run()
    {
        bool is_first = true;
        bool exec = true;
        std::string line;
        while (exec)
        {
            if (is_first)
            {
                std::cout << DISCLAIMER << std::endl;
                is_first = false;
            }
            std::cout << "R-- > ";

            std::getline(std::cin, line);
            if (line.empty()) exec = false;
            else
            {
                try
                {
                    std::cout << line << std::endl;
                }
                catch (parsing_exception& e)
                {
                    std::cerr << e.what() << std::endl;
                }
            }
        }
    }

private:
    interpreter() = default;
};

#endif //R_INTERPRETER_HPP
