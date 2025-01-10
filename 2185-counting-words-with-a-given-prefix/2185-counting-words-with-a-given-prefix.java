class Solution {
    public int prefixCount(String[] words, String pref) {
        int ret = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                ret++;
            }
        }
        return ret;
    }
}