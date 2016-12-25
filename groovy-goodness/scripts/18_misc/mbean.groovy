// JMX 서버에 접속해서 값을 읽고 처리하는 예
// 아무 Jetty 서버라도 띄우고 해보면 됨.
// https://www.eclipse.org/jetty/documentation/9.4.x/jmx-chapter.html
// export JETTY_BASE=$JETTY_HOME/demo-base
// JETTY_HOME 환경변수를 설정하고,
// $JAVA_HOME 환경변수에 JMX 관련 설정 넣어주고
// Jetty와 함께 기본적으로 들어오는 웹애플리케이션들 실행. Jetty 9.4 별다른 설정 없이도 자동 JMX enable

// java -Djetty.base=$JETTY_HOME/demo-base -jar start.jar

import javax.management.remote.*
import javax.management.*
import groovy.jmx.builder.*

def connection = new JmxBuilder().client(port: 8090, host: 'localhost')
connection.connect()

MBeanServerConnection mbeans = connection.MBeanServerConnection

println "Total MBeans: ${mbeans.MBeanCount}\n"

//def mbean = new GroovyMBean(mbeans, 'JMImplementation:type=MBeanServerDelegate')
// MBean object name 은 JConsole 등에서 MBean 항목에 마우스를 두면 알 수 있음.
def mbean = new GroovyMBean(mbeans, 'org.eclipse.jetty.webapp:type=webappcontext,context=test,id=0')
println mbean

//assert mbean.running : 없어짐
println "state : ${mbean.state}"
assert mbean.state == 'STARTED'

println "contextPath ${mbean.contextPath}"
assert mbean.contextPath == '/test'

mbean.contextPath = '/changed'
assert mbean.contextPath == '/changed'

mbean.stop() // execute stop operation
println "state : ${mbean.state}"
assert mbean.state == 'STOPPED'

// contextAttributes 관련된것들 작동안함.
//mbean.setContextAttribute 'groovy', true
//assert mbean.contextAttributes.groovy

def webBean = mbeans.queryNames(new ObjectName('org.eclipse.jetty.webapp:*'), null).find {
    it.getKeyProperty('context') == 'test-jndi' && it.getKeyProperty('type') == 'webappcontext'
}

mbean = new GroovyMBean(mbeans, webBean)
assert mbean
println mbean

// 옛날 방식으로 attribute/operation 접근하기

assert mbeans.getAttribute(webBean, 'state') == 'STARTED'
mbeans.invoke(webBean, "setContextAttribute", ['groovy', Boolean.TRUE] as Object[], ['java.lang.String', 'java.lang.Object'] as String[])
//assert (mbeans.getAttribute(webBean, "contextAttributes").get("groovy")) == true // contextAttributes 관련된것들 작동안함.

mbeans.setAttribute(webBean, new Attribute("distributable", Boolean.TRUE))
assert (mbeans.getAttribute(webBean, "distributable")) == true

// org.eclipse.jetty.webapp:* 에서 변경
def gmbeans = mbeans.queryNames(new ObjectName('org.eclipse.jetty.webapp:type=webappcontext,*'), null)
        .inject([]) { List result, javax.management.ObjectName name ->
            result << new GroovyMBean(mbeans, name)
        }

println '*' * 80

// displayName이 없는 것도 존재하는 듯.
gmbeans.each {
    println "${it.displayName} is ${it.state == 'STARTED' ? 'running' : 'stopped'}"
}