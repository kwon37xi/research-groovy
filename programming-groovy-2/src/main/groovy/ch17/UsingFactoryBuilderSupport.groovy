def builder = new RobotBuilder()

def robot = builder.robot('iRobot') {
    forward(dist: 20)
    left(rotation: 90)
    forward(speed: 10, duration: 5)
}

robot.go()

class RobotBuilder extends FactoryBuilderSupport {
    {
        // 객체 생성 직후, 생성자보다 먼저 실행되는 블럭

        registerFactory('robot', new RobotFactory())
        registerFactory('forward', new ForwardMoveFactory())
        registerFactory('left', new LeftTurnFactory())
    };
}

class Robot {
    String name
    def movements = []

    void go() {
        println "Robot $name operating..."
        movements.each { movement ->
            println movement
        }
    }
}

class ForwardMove {
    def dist
    String toString() { "move distance... $dist" }
}

class LeftTurn {
    def rotation
    String toString() {
        "turn left $rotation degrees"
    }
}

class RobotFactory extends AbstractFactory {
    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new Robot(name: value)
    }

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        // parent 는 Robot 객체
        parent.movements << child
    }
}

class ForwardMoveFactory extends AbstractFactory {

    boolean isLeaf() { true }

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        new ForwardMove()
    }

    @Override
    boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
        // node는 ForwardMove 객체
        if (attributes.speed && attributes.duration) {
            node.dist = attributes.speed * attributes.duration
            attributes.remove('speed')
            attributes.remove('duration')
        }
        true
    }
}

class LeftTurnFactory extends AbstractFactory {
    boolean isLeaf() { true }
    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new LeftTurn()
    }
}

def robotBuilder=  new RobotBuilder()
robotBuilder.robot('bRobot') {
    forward(dist: 20)
}.go()
