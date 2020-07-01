package baekjoon

import java.util.*
import kotlin.math.max

// maxProfit : 최대 이익
var maxProfit = 0

fun main() {
    // workDay : 일할 수 있는 남은 일 수
    // schedules : 남은 일정에 대한 정보, 각 인덱스는 날짜
    var workDay = readLine()!!.toInt()
    var schedules = Array<Work>(workDay+1) { Work(0,0) }

    // 일정 정보 입력 받아 저장
    for (i in 1 ..workDay) {
        var st = StringTokenizer(readLine(), " ")
        var duration = st.nextToken().toInt()
        var profit = st.nextToken().toInt()
        schedules[i] = Work(duration, profit)
    }

    // 최대 이익 계산
    getMaxProfit(schedules, 1, 0)
    println(maxProfit)
}

// schedules : 남은 일정에 대한 정보
// daysLeft : 일을 시작할 수 있기까지 남은 일 수
// currentDay : 현재 날짜
// workList : 수행할 업무 목록 정보
fun getMaxProfit(schedules: Array<Work>, currentDay: Int, totalProfit: Int) {
    // 기저 사례 : 퇴사 날에 도달 했을 때
    if (currentDay >= schedules.size) {
        maxProfit = max(maxProfit, totalProfit)
        return
    }

    // 상담을 할 때
    if (currentDay + schedules[currentDay].duration <= schedules.size)
        getMaxProfit(schedules, currentDay + schedules[currentDay].duration, totalProfit + schedules[currentDay].profit)

    // 상담을 하지 않았을 때
    if (currentDay + 1 <= schedules.size)
        getMaxProfit(schedules, currentDay + 1, totalProfit)
}

// duration : 일을 끝내는 데 걸리는 소요 일
// profit : 일을 함으로 얻을 이익
class Work(var duration: Int, var profit: Int) {}

/**
 * 재귀 호출이지만
 * 이번 문제는 상담을 했을 때 소요 일 까지의 사이를 계산하지 않아도 되는 특징이 있다.
 * 그래서 15!수열이지만 그것들을 고려하지 않으므로 경우의 수를 줄이게 된다.
 * 그 특징을 잡지 못해 시간 초과에 직면했다.
 * 반복문을 처음부터 도는 것이 아니라 특정 날짜로 이동하여 거기서 다시 상담목록을 수행한다.
 * */