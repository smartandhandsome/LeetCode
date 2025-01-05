class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val count = IntArray(s.length)
        for ((start, end, direction) in shifts) {
            for (i in start..end) {
                if (direction == 1) {
                    count[i]++
                } else if (direction == 0) {
                    count[i]--
                }
            }
        }
        var ret = ""
        s.forEachIndexed { index, c ->
            val offset = ((count[index] % 26) + 26) % 26
            println(offset)
            ret += ('a' + ((c - 'a') + offset) % 26)
        }
        return ret
    }
}
