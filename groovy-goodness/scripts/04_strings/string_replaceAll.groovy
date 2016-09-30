def s = "Programming with Groovy is fun!"

assert "Programming with Groovy rocks!" == s.replaceAll(~/is fun!/, "rocks!")

assert "Programming with Groovy is awesome." == s.replaceAll("fun!", "awesome.")

def replaced = s.replaceAll(/fun/) {
    def list = ['awesome', 'cool', 'okay']
    list[new Random().nextInt(list.size())]
}

println replaced
assert [
        "Programming with Groovy is awesome!",
        "Programming with Groovy is cool!",
        "Programming with Groovy is okay!"
].contains(replaced)

def txt = "Generated on 30-10-2009 with Groovy."

// 첫번째 인자는 전체 텍스트, 그 이후는 각 Group
def replacedTxt = txt.replaceAll(/.*(\d{2}-\d{2}-\d{4}).*(Gr.*)./) { all, date ,lang ->

    def dateObj = Date.parse('dd-M-yyyy', date)
    "The text '$all' was created with $lang on a ${dateObj.format('EEEE')}."

}
println replacedTxt
assert "The text 'Generated on 30-10-2009 with Groovy.' was created with Groovy on a 금요일." == replacedTxt
