class Solution {

    fun minimizeXor(num1: Int, num2: Int): Int {
        val targetSetBits = Integer.bitCount(num2)
        var result = 0


        var remainingBits = targetSetBits
        for (i in 31 downTo 0) {
            if (remainingBits == 0) break
            if ((num1 and (1 shl i)) != 0) {
                result = result or (1 shl i)
                remainingBits--
            }
        }


        for (i in 0..31) {
            if (remainingBits == 0) break
            if ((result and (1 shl i)) == 0) {
                result = result or (1 shl i)
                remainingBits--
            }
        }

        return result
    }
}