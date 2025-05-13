class Solution {
    
    public static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            deque.add(count[i]);
        }

        int result = s.length();
        for (int i = 0; i < t; i++) {
            int zCount = deque.removeLast() % MOD;
            int aCount = deque.removeFirst() % MOD;

            deque.addFirst(aCount + zCount);
            deque.addFirst(zCount);
            result = ((result % MOD) + (zCount % MOD)) % MOD;
        }
        return result;
    }

}
