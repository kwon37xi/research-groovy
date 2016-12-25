# JMX
* `GroovyMBean`를 사용하면 MBean attribute에 Bean 프라퍼티처럼 접근 가능해짐.

## Enable JMX
```
export JAVA_OPTS=-Dcom.sun.management.jmxremote \
-Djava.rmi.server.hostname=localhost \
-Dcom.sun.management.jmxremote.port=8090 \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false
```
* 실서비스에서는 ssl과, authentication을 활성화할 것.
export JAVA_OPTIONS=-Dcom.sun.management.jmxremote \
-Djava.rmi.server.hostname=localhost \
-Dcom.sun.management.jmxremote.port=8090 \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false