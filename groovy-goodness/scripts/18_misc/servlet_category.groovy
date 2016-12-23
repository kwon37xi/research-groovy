// ServletCategory : servlet/page/request/session 에 dot notation으로 접근 가능.
// 실제로는 작동하지 않았음. 좀 더 일반적인 Web Servlet 환경에서 테스트 필요.
@Grab(group = 'org.mortbay.jetty', module = 'jetty-embedded', version = '6.1.14')
import org.mortbay.jetty.*
import org.mortbay.jetty.servlet.Context

def startJetty() {
    def jetty = new Server(9090)
    def context = new Context(jetty, '/', Context.SESSIONS)
    context.resourceBase = '.'
    context.addServlet ch18_misc.Start, '/start'
    context.addServlet ch18_misc.Output, '/output'
    context.setAttribute 'version', '1.0'
    jetty.start()
}

startJetty()