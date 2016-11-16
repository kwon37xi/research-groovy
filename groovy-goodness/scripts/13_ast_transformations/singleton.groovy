// @Singleton

// 기존 Java 방식
public class StringUtil {
    private static final StringUtil instance = new StringUtil()

    private StringUtil() {

    }

    public static StringUtil getInstance() {
        return instance
    }
    int count(text) {
        text.size()
    }
}

assert 6 == StringUtil.instance.count('mrhaki')

@Singleton
class Util {
    int count(text) {
        text.size()
    }
}

assert 6 == Util.instance.count('mrhaki')

try {
    new Util()
} catch (e)  {
    assert e instanceof RuntimeException
    assert "Can't instantiate singleton Util. Use Util.instance" == e.message
}