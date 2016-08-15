package ch02

class Semi {
    def val = 3; // 아래 {} 블럭을 명확히 인지하려면 ; 필요. 안그러면 컴파일러가 closure라고 생각함.
    {
        // 인스턴스 초기화 블럭
        println "Instance Initialzer called..."
    }
}

println new Semi()