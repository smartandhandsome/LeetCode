class Solution {
    fun waysToSplitArray(nums: IntArray): Int {
        var prefixSum = 0L
        val totalSum = nums.sumOf { it.toLong() }
        
        var count = 0
        for (i in 0 until nums.size - 1) {
            prefixSum += nums[i]
            val suffixSum = totalSum - prefixSum
            if (prefixSum >= suffixSum) {
                count++
            }
        }
        return count
    }
}