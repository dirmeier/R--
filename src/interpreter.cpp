#include "interpreter.hpp"


std::string interpreter::interpret(std::string& text) const
{
    return expression(text);
}


std::string interpreter::expression(std::string& text) const
{
    parser_.init(text);
    //bstractSyntaxSubtree node = _parser.parse();
    //return String.valueOf(node.traverse());
    return "";
}

void interpreter::run() const
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
        try
        {
            std::cout << interpret(line) << std::endl;
        }
        catch (parsing_exception& e)
        {
            std::cerr << e.what() << std::endl;
        }
    }
}
const char* interpreter::DISCLAIMER = "\nWelcome to R-- v0.1 ('It's Alive').\n\n" \
  "R-- is a slower, experimental implementation of R in C++.\n" \
  "Be aware of bugs and minimal functionality.\n" \
  "If you are brave enough you can contribute.\n\n" \
  "Ctrl+C to quit! Good luck.\n\n";
