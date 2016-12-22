# Customizing Groovy Compiler

소스에 직접하지 않고 컴파일러 옵션으로 `@TypeChecked` 혹은 `@CompileStatic` 옵션을
주는 등의 컴파일러 커스터마이징이 가능하다.

이를 `--configscript` 옵션으로 적용할 수 있다.  Gradle에서도 `GroovyCompile` 태스크를
커스터마이징 할 수 있다.

## configuration script

* `CompilerConfiguration configuration`
* `CompilerCustomizationBuilder`

## Gradle
```groovy
compileGroovy.groovyOptions.configurationScript = file('src/groovyCompile/groovyConfig.groovy')
```