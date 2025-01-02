class Solution {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        
        val prefixSum = IntArray(words.size + 1)
        for (i in words.indices) {
            val word = words[i]
            val isVowelString = vowels.contains(word.first()) && vowels.contains(word.last())
            prefixSum[i + 1] = prefixSum[i] + if (isVowelString) 1 else 0
        }

        return queries.map { (start, end) ->
            prefixSum[end + 1] - prefixSum[start]
        }.toIntArray()
    }
}