// org.apache.ant:ant 의존성 필요함.
def ant = new AntBuilder()

def world = 'Groovy'
ant.echo("Hello ${world}")

def options = [src: 'http://mrhaki.blogspot.kr', dest: '/tmp/ant_builder_blog.html']
ant.get(options)

def zipfile = '/tmp/test.zip'
def current = '.'
ant.zip(destfile: zipfile) {
    fileset(dir: current) {
        include(name: '**/*.groovy')
    }
}