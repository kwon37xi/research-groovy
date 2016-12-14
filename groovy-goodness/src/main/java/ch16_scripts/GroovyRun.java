package ch16_scripts;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;

// -ea 옵션 주고 실행
public class GroovyRun {
    public static void main(String[] args) throws Exception {
        final GroovyClassLoader classLoader = new GroovyClassLoader();

        final StringBuilder groovyScript = new StringBuilder();
        groovyScript.append("class Sample {")
                .append(" String sayIt(name) { ")
                .append("    \"Groovy says: Cool $name!\" ")
                .append("  }")
                .append("}");

        Class groovy = classLoader.parseClass(groovyScript.toString());
        GroovyObject groovyObj = (GroovyObject) groovy.newInstance();
        // 동적 메소드 호출
        String output = (String) groovyObj.invokeMethod("sayIt", new Object[] { "mrhaki" });

        System.out.println("output : " + output);
        assert output.equals("Groovy says: Cool mrhaki!");

        groovy = classLoader.parseClass(new File("groovy-goodness/scripts/16_scripts/groovy_script_in_java.groovy"));
        groovyObj = (GroovyObject)groovy.newInstance();
        output = (String) groovyObj.invokeMethod("scriptSays", new Object[] { "mrhaki", new Integer(2) });
        System.out.println("output 2 : " + output);
        assert output.equals("Hello mrhaki, from groovy. Hello mrhaki, from groovy. ");
    }
}
