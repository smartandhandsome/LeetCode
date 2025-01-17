class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var ret = 0
        derived.forEach { ret = ret.xor(it) }
        return ret == 0
    }
}