package ch02

class Robot {
    def type, height, width
    def access(Map location, weight, fragile) {
        println "Received fragile? $fragile, weight: $weight, loc: $location"
    }
}

// 생성자가 없을 때, 객체 생성 후처리 작업으로 named parameter 값을 필드값으로 설정
def robot = new Robot(type: 'arm', width: 10, height: 40)

println "$robot.type, $robot.height, $robot.width"

// 메소드의 파라미터가 name/value 페어일 경우, 메소드의 첫 인자를 Map으로 가정한다.
// 따라서 name/value pair가 앞에 있던 뒤에 있던, 첫 인자인 location을 Map으로 가정.
// 이런 가변 name/value pair 를 받고 싶으면 가급적 첫 인자를 Map location 형태로 Map으로 타입 명시할 것
robot.access(x: 30, y: 20, z: 10, 50, true)
robot.access(50, true, x: 30, y: 20, z: 10)