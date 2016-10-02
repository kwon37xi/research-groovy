// Object.sprinft 추가됨.
// String.format 과 같은듯

assert 'Groovy is cool!' == sprintf('%2$s %3$s %1$s', ['cool!', 'Groovy', 'is'])

assert '00042' == sprintf('%05d', 42)

