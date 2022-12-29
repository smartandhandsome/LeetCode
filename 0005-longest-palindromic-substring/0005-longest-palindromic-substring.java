class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        String answer = s.substring(0, 1);
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > 0; j--) {
                if (j - i < answer.length()) {
                    continue;
                }
                int tempI = i;
                int tempJ = j;
                while (s.charAt(tempI) == s.charAt(tempJ) && tempI < tempJ) {
                    tempI++;
                    tempJ--;
                }
                if (tempJ <= tempI) {
                    answer = s.substring(i, j + 1);
                }
            }
        }
        return answer;
    }
}