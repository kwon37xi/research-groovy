package ch16_scripts;

import groovy.util.Eval;

import java.util.HashMap;
import java.util.Map;

public class EvalGroovyTest {
    public static void main(String[] args) {
        // Hello from Groovy
        System.out.println(Eval.me("def language = 'Groovy'; \"Hello from ${language}\";").toString());

        final Map values = new HashMap();
        values.put("name", "mrhaki");
        values.put("lang", "Groovy");

        String expression = "\"Hello $params.name from $params.lang\"";

        // Hello mrhaki from Groovy
        System.out.println(Eval.me("params", values, expression));

        // expression에 "x" 라는 변수명으로 바인딩해서 값을 넘겨줌.
        // true
        System.out.println(Eval.x("mrhaki", "x.any { it =~ 'a' }"));

        // expression에 x, y 라는 변수명으로 바인딩해서 값을 2개 넘겨줌
        // true
        System.out.println(Eval.xy("mrhaki", "h", "x.any { it =~ y }"));

        // x, y, z 변수명으로 바인딩
        expression = "x.\"$z\"() * y"; // x."$z"() * z
        // GROOVYGROOVY
        System.out.println(Eval.xyz("groovy", 2, "toUpperCase", expression)); // "groovy"."toUpperCase"() * 2

    }
}
