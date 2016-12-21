# GroovyDoc

* Gradle 에서 `groovy` 플러그인을 활성화하면 `groovydoc` 태스크 생김
* `org.codehaus.tools.groovydoc.gstringTemplates` 패키지에 다양한 템플릿 HTML 들이 들어있음.
* 동일안 패키지구조와 동일한 이름의 파일을 만들어서 커스터마이징 가능.
* 새로운 템플릿을 GroovyDoc 툴의 클래스패스에서 우선 적용되게 하면 됨.
* groovydoc 설정 블럭의 프라퍼티가 `props`라는 맵에 저장되어 템플릿으로 전달됨.