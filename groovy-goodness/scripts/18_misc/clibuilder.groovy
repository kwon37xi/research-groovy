// 명령행 인자 : String[] args 로 읽을 수 있음.
@Grapes(
        @Grab(group = 'commons-cli', module = 'commons-cli', version = '1.3.1')
)
import java.text.*

def showdate(args) {
    def cli = new CliBuilder(usage: 'showdate.groovy -[chflms]')

    cli.with {
        h longOpt: 'help', 'Show usage information'
        c longOpt: 'format-custom', args: 1, argName: 'format', 'Format date with custom format defined by "format"'
        f longOpt: 'format-full', 'Use DateFormat#FULL format'
        l longOpt: 'format-long', 'Use DateFormat#LONG format'
        m longOpt: 'format-medium', 'Use DateFormat#MEDIUM format(default)'
        s longOpt: 'format-short', 'Use DateFormat#SHORT format'
    }

    def options = cli.parse(args)

    if (!options) {
        return
    }

    if (options.h) {
        cli.usage()
        return
    }

    def df = DateFormat.getDateInstance(DateFormat.MEDIUM)
    if (options.f) {
        df = DateFormat.getDateInstance(DateFormat.FULL)
    } else if (options.'format-long') {
        df = DateFormat.getDateInstance(DateFormat.LONG)
    } else if (options.'format-medium') {
        df = DateFormat.getDateInstance(DateFormat.MEDIUM)
    } else if (options.s) {
        df = DateFormat.getDateInstance(DateFormat.SHORT)
    } else if (options.'format-custom') {
        df = new SimpleDateFormat(options.c)
    }

    def prefix = ''
    def date = new Date()
    def extraArguments = options.arguments()
    if (extraArguments) {
        date = Date.parse(extraArguments[0])
        if (extraArguments.size() > 1) {
            prefix = extraArguments[1..-1].join(' ')
        }
    }
    "$prefix${df.format(date)}"
}

Locale.setDefault(Locale.US)
assert showdate(['--format-short', '2009/12/1']) == '12/1/09'
assert showdate(['-s', '2009/12/1']) == '12/1/09'
assert showdate(['2009/12/1']) == 'Dec 1, 2009'
assert showdate(['--format-medium', '2009/12/1']) == 'Dec 1, 2009'
assert showdate(['-m', '2009/12/1']) == 'Dec 1, 2009'
assert showdate(['--format-long', '2009/12/1']) == 'December 1, 2009'
assert showdate(['-l', '2009/12/1']) == 'December 1, 2009'
assert showdate(['--format-full', '2009/12/1']) == 'Tuesday, December 1, 2009'
assert showdate(['-f', '2009/12/1']) == 'Tuesday, December 1, 2009'
assert showdate(['2009/12/1', 'Default', 'date', 'format: ']) == 'Default date format: Dec 1, 2009'
assert showdate(['-m', '2009/12/1', 'Important date: ']) == 'Important date: Dec 1, 2009'
assert showdate(['-c', "'week' w 'of the year' yyyy G", '2009/12/1']) == 'week 49 of the year 2009 AD'
assert showdate(['--format-custom', 'yyyy/MM/dd', '2009/12/1']) == '2009/12/01'
assert showdate(['-cyyyy', '2009/12/1']) == '2009'
assert showdate(['--format-custom', 'yyyy/MM/dd']) == new Date().format('yyyy/MM/dd')