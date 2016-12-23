package ch18_misc

import groovy.servlet.ServletCategory

import javax.servlet.ServletConfig
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Start extends HttpServlet {
    def application

    void init(ServletConfig config) {
        super.init(config)
        application = config.servletContext
        use(ServletCategory) {
            application.author = 'mrhaki'
        }
    }

    void doGet(HttpServletRequest request, HttpServletResponse response) {
        def session = request.session
        use(ServletCategory) {
            if (session.counter) {
                session.counter++
            } else {
                session.counter = 1
            }

            request.pageTitle = 'Groovy Rocks!'
        }

        println "forwarding to output"
        application.getRequestDispatcher('/output').forward(request, response)
    }
}