class Solution {
    fun findNumbers(nums: IntArray): Int {
        var count = 0;
        nums.forEach {
            if (it.toString().length % 2 == 0) {
                count++
            }
        }
        return count
    }
}
