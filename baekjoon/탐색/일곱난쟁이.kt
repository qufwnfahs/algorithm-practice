package baekjoon

fun main() {
    // heights : 모든 난쟁이들의 키
    // dwarfs : 일곱 난쟁이들의 키
    // selected : 선택한 난쟁이들을 표시
    var heights = IntArray(NUM_DWARFS)
    var dwarfs = IntArray(REAL_DWARFS)
    var selected = BooleanArray(NUM_DWARFS)

    // 난쟁이들의 키 정보를 입력 받아 저장
    for (i in heights.indices) {
        heights[i] = readLine()!!.toInt()
    }

    findDwarfs(heights, dwarfs, selected, 0)

    dwarfs.sort()
    dwarfs.forEach { println("$it") }
}

// 9명 중 진짜 일곱 난쟁이를 찾아낸다.
// heights : 모든 난쟁이들의 키
// dwarfs : 일곱 난쟁이 들의 키
// n : 골라낸 난쟁이 수
fun findDwarfs(heights: IntArray, dwarfs: IntArray, selected: BooleanArray, n: Int): Boolean {
    // 기저 사례 : 골라낸 난쟁이가 일곱 명이면 종료
    if (n == 7)
        return dwarfs.sum() == 100

    // 모든 난쟁이들을 선택했는지 검사하여 안 선택한 난쟁이를 선택하여 진행
    for (i in heights.indices) {
        if (!selected[i]) {
            dwarfs[n] = heights[i]
            selected[i] = true
            if (findDwarfs(heights, dwarfs, selected, n + 1)) // 7명을 골랐을 때 키의 합이 100이었다면 return
                return true
            dwarfs[n] = 0
            selected[i] = false
        }
    }
    return false
}

const val NUM_DWARFS = 9
const val REAL_DWARFS = 7
