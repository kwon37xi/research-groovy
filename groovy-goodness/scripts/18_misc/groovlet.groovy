/*
Groovlet

groovy servlet

* `request` : `HttpServletRequest`
* `response` : `HttpServletRequest`
* `session`
* `headers`
* `out`
* `sout`
* `html`

 */

@Grab(group = 'org.mortbay.jetty', module = 'jetty-embedded', version = '6.1.14')
import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import groovy.servlet.*

def startJetty() {
    def jetty = new Server(9090)

    // allow session
    def context = new Context(jetty, '/', Context.SESSIONS)

    // 현재 디렉토리를 groovlet 탐색 디렉토리로 지정
    context.resourceBase = '.'

    // All files ending with .groovy will be served
    context.addServlet(GroovyServlet, '*.groovy')
    context.setAttribute('version', '1.0')
    jetty.start()
}

println "Starting jetty, Press Ctrl+C to stop."
startJetty()
