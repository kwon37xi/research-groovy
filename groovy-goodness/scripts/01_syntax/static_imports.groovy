import java.net.HttpURLConnection as http

import static java.net.HttpURLConnection.HTTP_OK
import static java.net.HttpURLConnection.HTTP_OK as okay
import static java.net.HttpURLConnection.setFollowRedirects as redirect

redirect false

assert false == http.followRedirects

def c = (http) 'http://www.mrhaki.com/'.toURL().openConnection()
assert c instanceof HttpURLConnection
assert okay == c.responseCode
assert HTTP_OK == c.responseCode