class Solution {

    private var sum: IntArray? = null
    private var k: Int? = null

    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        this.k = k

        sum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            sum!![i + 1] = sum!![i] + nums[i]
        }

        val left = IntArray(nums.size)
        var maxNumIndex = 0;
        for (i in 0..nums.size - k) {
            if (sumIndexToIndPlusK(i) > sumIndexToIndPlusK(maxNumIndex)) {
                maxNumIndex = i
            }
            left[i] = maxNumIndex
        }

        val right = IntArray(nums.size)
        maxNumIndex = nums.size - k
        for (i in nums.size - k downTo 0) {
            if (sumIndexToIndPlusK(i) >= sumIndexToIndPlusK(maxNumIndex)) {
                maxNumIndex = i
            }
            right[i] = maxNumIndex
        }

        var ret = intArrayOf(-1, -1, -1)
        var maxSum = -1
        for (midIndex in k..(nums.size - (2 * k))) {
            val leftIndex = left[midIndex - k]
            val rightIndex = right[midIndex + k]

            val total = sumIndexToIndPlusK(leftIndex) +
                    sumIndexToIndPlusK(midIndex) +
                    sumIndexToIndPlusK(rightIndex)

            if (total > maxSum) {
                maxSum = total
                ret = intArrayOf(leftIndex, midIndex, rightIndex)
            }
        }

        return ret
    }

    private fun sumIndexToIndPlusK(index: Int): Int {
        return sum!![index + k!!] - sum!![index]
    }
}
