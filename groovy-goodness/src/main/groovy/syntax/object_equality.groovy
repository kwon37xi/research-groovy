Integer myInt = 42
Integer anotherInt = myInt
Integer newInt = 42
Integer different = 101

assert myInt == anotherInt
assert myInt.is(anotherInt)

assert myInt == newInt
assert myInt != different

assert myInt.is(newInt)