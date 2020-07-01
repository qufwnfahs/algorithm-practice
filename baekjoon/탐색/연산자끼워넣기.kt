package baekjoon

var maxVal = Int.MIN_VALUE
var minVal = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    // count : 숫자 개수
    // numberArr : 숫자를 저장할 배열
    // operArr : 연산자 개수를 저장한 배열
    var count = readLine().toInt()
    var numberArr = readLine().split(" ").map(String::toInt).toTypedArray()
    var operArr = readLine().split(" ").map(String::toInt).toTypedArray()

    getMinMaxValue(numberArr, operArr, numberArr[0], 0)

    println("$maxVal\n$minVal")
}

// numberArr : 숫자 목록을 가진 배열
// operArr : 연산자 개수를 저장한 배열
// result : 결과
// toPick : 고를 연산자 인덱스
fun getMinMaxValue(numberArr: Array<Int>, operArr: Array<Int>, result: Int, toPick: Int) {
    // 기저 사례 : 연산자를 모두 사용했다면 종료
    if (operArr.all { it == 0 }) {
        if (result < minVal) minVal = result
        if (result > maxVal) maxVal = result
        return
    }

    for (i in operArr.indices) {
        if (operArr[i] != 0) {
            operArr[i] -= 1

            getMinMaxValue(numberArr, operArr,
                when (i) {
                    0 -> result + numberArr[toPick + 1]
                    1 -> result - numberArr[toPick + 1]
                    2 -> result * numberArr[toPick + 1]
                    3 -> result / numberArr[toPick + 1]
                    else -> return
                }, toPick + 1)

            operArr[i] += 1
        }
    }
}