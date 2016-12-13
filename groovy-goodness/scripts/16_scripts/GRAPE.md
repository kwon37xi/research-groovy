# Grape

## Custom repo
```
@GrabResolver(name='custom',
    root='http://url/...',
    m2Compatible='true')
@Grab('group:artifact:version')
....
```

## 받은 의존성 jar 경로
```
# grape resolve group artifact version
$ grape resolve commons-lang commons-lang 2.5
/home/kwon37xi/.groovy/grapes/commons-lang/commons-lang/jars/commons-lang-2.5.jar

$ grape resolve -dos commons-lang commons-lang 2.5
set CLASSPATH=/home/kwon37xi/.groovy/grapes/commons-lang/commons-lang/jars/commons-lang-2.5.jar

$ grape resolve -shell commons-lang commons-lang 2.5
export CLASSPATH=/home/kwon37xi/.groovy/grapes/commons-lang/commons-lang/jars/commons-lang-2.5.jar

$ grape resolve -ant commons-lang commons-lang 2.5
<pathelement location="/home/kwon37xi/.groovy/grapes/commons-lang/commons-lang/jars/commons-lang-2.5.jar">

$ grape resolve -ivy commons-lang commons-lang 2.5
<dependency org="commons-lang" name="commons-lang" revision="2.5">

```

## Grape 의존성 저장 디렉토리 변경

* 기본 `$USER_HOME/.groovy/grapes`
* Java System Property `grape.root` 로 변경 가능

```
$ groovy -Dgrape.root=deps/ sample.groovy 
```

## 의존성 제외
* `@GrabExclude` : group, module 명시

```
@GrabExclude(group = 'commons-logging', module='commons-logging')
@GrabExclude('commons-logging:commons-logging')
```
