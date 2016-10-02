enum Compass {
    NORTH, EAST, SOUTH, WEST
}

def north = 'NORTH' as Compass
assert north == Compass.NORTH

Compass south = 'south'.toUpperCase() // type을 자동인식해서 변환
assert south == Compass.SOUTH

def result = ['EA', 'WE'].collect {
    "${it}ST" as Compass
}

assert result[0] == Compass.EAST
assert result[1] == Compass.WEST