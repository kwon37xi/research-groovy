class Company {
    Address address
    String name
}

class Address {
    Street street
    String postalCode
    String city
}

class Street {
    String name
    String number
    String additionalInfo
}

def company = new Company(address: new Address(street: new Street(name: 'Taepyongro')))

println company?.address?.street?.name

// 하나라도 null이면 전체 식이 null로 평가됨.
company.address = null
println company?.address?.street?.name

company = null
println company?.address?.street?.name