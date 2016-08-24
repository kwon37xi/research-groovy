package ch07

class PriceExtension {
    public static double getPrice(String self) {
        def url = "http://ichart.finance.yahoo.com/table.csv?s=${self}".toURL()
        def data = url.readLines()[1].split(",")
        Double.parseDouble(data[-1])
    }
}
