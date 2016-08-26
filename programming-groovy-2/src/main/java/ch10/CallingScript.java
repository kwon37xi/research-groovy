package ch10;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CallingScript {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("groovy");
        System.out.println("Calling script from Java");
        try {
            engine.eval("println 'Hello from groovy'");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
