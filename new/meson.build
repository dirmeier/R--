project(
  'R--',
  'cpp',
  version : '0.0.1',
  default_options : [
    'buildtype=release',
    'warning_level=3',
    'cpp_std=c++11',
    'b_ndebug=if-release'],
  license : 'GPL-3',
  meson_version : '>= 0.46.0')

add_global_arguments([
    '-DPACKAGE_NAME="' + meson.project_name() + '"',
    '-DPACKAGE_VERSION="' + meson.project_version() + '"'],
  language : 'cpp')

subdir('src')

if get_option('tests')
  subdir('testsuite')
endif
