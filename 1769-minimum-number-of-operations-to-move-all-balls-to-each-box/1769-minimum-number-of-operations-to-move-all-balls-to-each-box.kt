class Solution {
    fun minOperations(boxes: String): IntArray {
        var left = 0
        var right = 0
        var sum = 0;
        for (i in 1..<boxes.length) {
            if (boxes[i] == '1') {
                right++
                sum += i
            }
        }

        val ret = IntArray(boxes.length)
        ret[0] = sum
        if (boxes[0] == '1') {
            left++
        }
        for (i in 1..<boxes.length) {

            sum = sum + left - right
            ret[i] = sum

            if (boxes[i] == '1') {
                left++
                right--
            }
        }
        return ret
    }
}