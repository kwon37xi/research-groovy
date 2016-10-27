// rcurry() right to left
// ncurry() specific index

// see src/main/groovy/
import org.apache.commons.lang.RandomStringUtils as RSU

def randomClosure = { size, letters, numbers ->
    RSU.random size, letters, numbers
}

// letters = false, numbers = true
def randomNumbers = randomClosure.rcurry(false, true)
// letters = true, numbers = false
def randomLetters = randomClosure.ncurry(1, true, false)

println randomClosure(10, true, true); // 문자 숫자 아무거나 10개
println randomNumbers(10)
println randomLetters(10)