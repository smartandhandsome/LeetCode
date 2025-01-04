class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val map = mutableMapOf<Char, IntArray>()
        s.forEachIndexed { index, char ->
            map[char] = map[char]?.apply {
                this[1] = index
            } ?: intArrayOf(index, index, 1)
        }
        
        var ret = 0;
        for (outer in map) {
            val (first, last) = outer.value

            val palindromes = mutableSetOf<Char>()
            for (i in first + 1..<last) {
                palindromes.add(s[i])
            }
            ret += palindromes.size
        }
        return ret
    }
}