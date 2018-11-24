/**
 * r--: Another R interpreter in C++
 * <p>
 * Copyright (C) Simon Dirmeier
 * <p>
 * This file is part of r--.
 * <p>
 * r-- is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * r-- is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with r--. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author: Simon Dirmeier
 * @email: simon.dirmeier@web.de
 */


#include <cstdlib>
#include <iostream>

#include "interpreter.hpp"

int main(int /*argc*/, char* /*argv*/[])
{
    interpreter::instance().run();
    return EXIT_SUCCESS;
}
