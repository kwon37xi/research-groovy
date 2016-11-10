import groovy.xml.*

def markupBuilder = new StreamingMarkupBuilder()
def xml = markupBuilder.bind { builder ->
    client {
        name 'mrhaki'
        fullName 'Hubert A. Klein Ikkink'
        buildAddress builder, 'Main St.', 42, 'Ducktown'
        delivery {
            buildAddress builder, 'Main Av.', 101, 'Springfield'
            remarks 'Durring office hours'
        }
        buildItems builder
    }
}


def buildAddress(builder, streetName, number, city) {
    builder.address {
        street streetName
        houseNumber number
        buildCity builder, city
    }
}

def buildCity(builder, city) {
    builder.city city
}

def buildItems(builder) {
    builder.items {
        ['iPod', 'eBook'].eachWithIndex { product, index ->
            item(id: index + 1) {
                name "Item $product"
            }
        }
    }
}

println XmlUtil.serialize(xml)