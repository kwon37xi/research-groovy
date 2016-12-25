// concurrent environment.
// 작동원리는 이해했지만, 아래 코드는 openweathermap API가 변경되어 작동하지 않음.
/*
 GPars Dataflow 는 여러 태스크(쓰레드)에서 공유
 쓰기 : 한번
 읽기 : 여러번
 아직 쓰기 안된 상태에서 읽기가 일어나면 써질 때까지 기다림. 하지만 non-blocking

 Dataflows : 여러 dataflow 를 읽고 쓸 수 있다.
*/

import groovyx.gpars.dataflow.Dataflows
import static groovyx.gpars.dataflow.Dataflow.task

final Dataflows data = new Dataflows()

task {
    println "Task 'convertTemperature' is wating for dataflow variable 'cityWeather'"

    // cityWeather 변수가 설정될때까지 기다림.
    final cityWeather = data.cityWeather
    final cityTemperature = cityWeather.temperature

    println "Task 'convertTemperature' got dataflow variable 'cityWeather'"

    final params = [Temperature: cityTemperature,
        FromUnit: 'degreeCelsius',
        ToUnit: 'degreeFahrenheit']
    final url = "http://www.webservicex.net/ConvertTemperature.asmx/ConvertTemp"
    final result = downloadData(url, params)
    data.temparature = result.text()
}

// find temperature for city
task {

    try {
        println "Task 'findCityWeather' is wating for dataflow variable 'searchCity'"

        // 다른 태스크에서 도시이름을 설정할 때까지 기다림.
        final city = data.searchCity

        println "Task 'findCityWeather' got dataflow variable 'searchCity'"

        final params = [q    : city,
                            units: 'metric',
                            mode : 'xml']
        final url = "http://api.openweathermap.org/data/2.5/find"
        final result = downloadData(url, params)
        final temperature = result.list.item.temperature.@value

        data.cityWeather = [city: city, temperature: temperature]
    } catch (ex) {
        ex.printStackTrace()
    }
}

// parseCity
task {
    println "Task 'parseCity' is wating for dataflow variable 'searchCity'"

    final city = data.searchCity

    println "Task 'parseCity' got dataflow variable 'searchCity'"

    final cityName = city.split(',').first()

    data.cityName = cityName
    println "parseCity : ${cityName}"

}

final startSearch = task {
    data.searchCity = args[0]
}

final printValueBound = { dataflowVar, value ->
    println "Variable '$dataflowVar' bound to '$value'"

    data.searchCity printValueBound.curry('searchCity')
    data.cityName printValueBound.curry('cityName')
    data.cityWeather printValueBound.curry('cityWeather')
    data.temperature printValueBound.curry('temperature')
}


// dataflow 변수는 한 번 설정되면 다시 계산되지 않고 계속 캐시된다.
println "Main thread is wating for dataflow variables 'cityWeather', 'temperature' and 'cityName'"
final cityInfo = data.cityWeather + [tempFahrenheit: data.temparature] + [cityName: data.cityName] // cityWeather는 Map

println """
Temperature in city $cityInfo.city):
$cityInfo.temperature Celcius
$cityInfo.tempFahrenheit Fahrenheit
"""

def downloadData(requestUrl, requestParams) {
    final params = requestParams.collect { it }.join('&')
    final url = "${requestUrl}?${params}"
    final response = new XmlSlurper().parseText(url.toURL().text)
    response
}