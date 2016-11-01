// Closure를 Java 8 lambda 부분에 넣을 수 있다.

import groovy.transform.*

import java.util.stream.Collectors

@Canonical
class Building {
    String name
    int floors
    boolean officeSpace
}

def officeSpace = new Building('Initech office', 3, true)
def theOffice = new Building('Wernham Hogg Paper Company', 4, true)
def coffeeShop = new Building('Hunter Green', 1, false)

def buildings = [officeSpace, theOffice, coffeeShop]

def mapBuildingName = { building -> building.name }

// invoke Java Stream API  with lambda methods

def officeBuildingNames = buildings.stream()
        .filter { building -> building.officeSpace && building.floors > 2 }
        .map(mapBuildingName)
        .collect(Collectors.toList())

println officeBuildingNames

assert officeBuildingNames == ['Initech office', 'Wernham Hogg Paper Company']