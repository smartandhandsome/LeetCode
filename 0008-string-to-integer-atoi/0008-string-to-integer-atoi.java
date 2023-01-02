class Solution {
    public int myAtoi(String s) {
        char sign = '\0';
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && stringBuilder.length() >= 0) {
                if (sign == '\0' && (s.charAt(i) == '+' || s.charAt(i) == '-') && stringBuilder.length() == 0) {
                    sign = s.charAt(i);
                    continue;
                }
                break;
            }
            stringBuilder.append(s.charAt(i));
        }
        String pure = "";
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != '0') {
                pure = stringBuilder.substring(i);
                break;
            }
        }
        if (pure.length() > 10) {
            return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else if (pure.length() == 0) {
            return 0;
        }

        Long answer = Long.parseLong(pure);
        if (sign == '-') {
            answer = -answer;
        }
        if (answer >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (answer <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return answer.intValue();
        }
    }
}