.PHONY: clean
.PHONY: format
.PHONY: check

all: build

build:
	meson build . && meson compile -C build -v

debug:
	meson build . --buildtype debug \
	  -Db_pgo=generate \
	  -Db_sanitize=address,undefined \
	  -Db_coverage=true && \
	  meson compile -C build -v

clean:
	rm -rf build

format:
	clang-format -i src/*hpp src/*cpp tests/*cpp

check:
	cppcheck src/*.cpp include/*.hpp
