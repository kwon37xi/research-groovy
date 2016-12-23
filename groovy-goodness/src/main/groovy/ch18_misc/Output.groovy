package ch18_misc

import groovy.servlet.ServletCategory
import groovy.xml.MarkupBuilder

import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Output extends HttpServlet {
    def context

    @Override
    void init(ServletConfig config) throws ServletException {
        super.init(config)
        context = config.servletContext
        println "output initialized"
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        def html = new MarkupBuilder(response.writer)
        def session = request.session
        println "output started"

        use(ServletCategory) {
            html.html {
                head {
                    title request.pageTitle
                }
                body {
                    h1 request.pageTitle
                    h2 "$context.version written by $context.author"
                    p "You have requested this page $session.counter times."
                }
            }
        }
    }
}