// groovy -l port 로 시작하면 Groovy 서버가 뜬다.
// init=truy : client 커넥션을 하나도 실행하지 않았을 때.
// socket : Socket 객체
// out : PrintWriter output. println 을 사용하면 client에게 전송됨.
// line : input 컨텐츠. 줄끝문자로 종료됨.
// "success" 문자열을 전송해서 접속 종료.

// client에서 한줄 한줄 보낼 때마다 아래 스크립트 전체가 실행된다.
// "success" 문자열을 클라이언트에 전송하면 client와 접속을 끊는다.

println "Running script ${new Date()}"

if (init) {
    meta = [:]
    // socket 프라퍼티에 접근
    meta.host = socket.inetAddress.hostAddress
}

if (line.startsWith('OUTPUT')) {
    println()
    println "Server running on $meta.host"
    println "Meta info:"
    println "----------"
    meta.each { key, value ->
        println "$key = $value"
    }
    println()
    return "success"
} else {
    metaInfo = line.tokenize(":")
    meta[metaInfo[0]] = metaInfo[1]
}

// groovy -l 9010 server_socket_script.groovy
/*
$ telnet localhost 9010
Trying 127.0.0.1...
Connected to localhost
Escape character is '^]'.
test:true
username:mrhaki
language:Groovy
OUTPUT
Server running on 127.0.0.1
Meta info:
----------
host = 127.0.0.1
test = true
username = mrhaki
language = Groovy
Connection closed by foreign host.
Original blog post written on December
 */