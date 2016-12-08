// Groovy 2.3 부터 package나 import 문에 @BaseScript 가능해짐.
// Script.run 메소드를 구현할 수 있다.
// 스크립트 시작/종료 시점에 실행할 코드 주입가능.
// custom script 클래스에 abstract method가 있으면, 실제 실행하는 스크립트의 컨텐츠는 그 abstract method의 구현으로 간주된다.

@groovy.transform.BaseScript(CustomScript)
import ch15_dsl_builder.CustomScript

final String value = 'Groovy rules'
assert value.size() == 12

value
