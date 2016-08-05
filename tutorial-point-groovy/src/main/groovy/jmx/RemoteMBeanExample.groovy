package jmx

import javax.management.ObjectName
import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

// Connect to remote tomcat server
// tomcat jvm option :  -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1091  -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
class RemoteMBeanExample {
    static void main(String[] args) {
        def serverUrl = 'service:jmx:rmi:///jndi/rmi://localhost:1091/jmxrmi'
        def server = JmxFactory.connect(new JmxUrl(serverUrl)).MBeanServerConnection
        def serverInfo = new GroovyMBean(server, 'Catalina:type=Server').info()
        println "Connected to: $serverInfo"

        def query = new ObjectName("Catalina:*")
        String[] allNames = server.queryNames(query, null)

        def modules = allNames.findAll { name ->
            name.contains('j2eeType=WebModule')
        }.collect {
            new GroovyMBean(server, it)
        }

        println "Found ${modules.size()} web modules. Processing...."

        modules.each { m ->
            println "Module ${m.name()} ${m.processingTime}, ${m.path}"
        }

    }
}
