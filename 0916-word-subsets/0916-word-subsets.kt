class Solution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val maxFreq = mutableMapOf<Char, Int>()
        for (word in words2) {
            val freq = calculateFrequency(word)
            for ((char, count) in freq) {
                maxFreq[char] = maxOf(maxFreq.getOrDefault(char, 0), count)
            }
        }

        val result = mutableListOf<String>()
        for (word in words1) {
            val freq = calculateFrequency(word)
            if (isUniversal(freq, maxFreq)) {
                result.add(word)
            }
        }

        return result
    }

    private fun calculateFrequency(word: String): Map<Char, Int> {
        val freq = mutableMapOf<Char, Int>()
        for (char in word) {
            freq[char] = freq.getOrDefault(char, 0) + 1
        }
        return freq
    }

    private fun isUniversal(wordFreq: Map<Char, Int>, maxFreq: Map<Char, Int>): Boolean {
        for ((char, count) in maxFreq) {
            if (wordFreq.getOrDefault(char, 0) < count) {
                return false
            }
        }
        return true
    }
}
