package ch10;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * GroovyScriptEngine.run 메소드를 통해 스크립트 파일을 실행할 수 있다.
 */
public class ParameterPassing {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("groovy");
        engine.put("name", "KwonNam");
        engine.eval("println \"Hello ${name} from Groovy\"; name += '!' ");

        String name = (String) engine.get("name");
        System.out.println("Back in Java: " + name);

    }
}
