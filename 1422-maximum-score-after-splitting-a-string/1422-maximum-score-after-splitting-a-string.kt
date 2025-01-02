import kotlin.math.max

class Solution {
    fun maxScore(s: String): Int {
        val totalOnes = s.count { it == '1' }
        if (totalOnes == s.length || totalOnes == 0) return s.length - 1

        var answer = 0
        var leftZeros = 0
        var currentOnes = totalOnes

        for (i in 0 until s.length - 1) {
            if (s[i] == '0') {
                leftZeros++
            } else {
                currentOnes--
            }
            answer = max(answer, leftZeros + currentOnes)
        }
        return answer
    }
}