new File('/tmp').eachFileMatch(~/.*.jpg$/) {
    def converter = "convert /tmp/${it.name} -thumbnail 100x100 /tmp/thumb-${it.name - '.jpg'}.gif".execute()
    converter.waitFor()

    if (converter.exitValue()) {
        println "Error creating thumbnail for ${it.name}:"
        println converter.text
    } else {
        println "Created a thumbnail for ${it.name}"
    }
}

def thumbnail = ["convert", "/tmp/sleepy.jpg", "-thumbnail", "50x50", "/tmp/sleepy-list-thumbnail.gif"].execute()
thumbnail.waitFor()

println "Exit value: ${thumbnail.exitValue()}"
println "Output : ${thumbnail.text}"
