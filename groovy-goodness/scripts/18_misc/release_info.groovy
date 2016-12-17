// ReleaseInfo 클래스로부터 Groovy에 관한 정보를 얻을 수 있다.

import org.codehaus.groovy.util.ReleaseInfo

assert ReleaseInfo.version == '2.4.7'
assert ReleaseInfo['ImplementationVersion'] == '2.4.7'
assert ReleaseInfo.get('BuildTime') == '06:50 PM'
assert ReleaseInfo.get('BundleVersion') == '2.4.7'
assert ReleaseInfo['BuildDate'] == '03-Jun-2016'
