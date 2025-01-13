class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }
        int ret = 0;
        for (Map.Entry<Character, Integer> entry : charToCount.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 1) {
                ret += 1;
            } else {
                ret += 2;
            }
        }
        return ret;
    }
}
