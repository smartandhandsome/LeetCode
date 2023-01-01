class Solution {
    public int reverse(int x) {
        boolean sign = x > 0;
        int temp = sign ? x : -x;
        if (temp == Integer.MIN_VALUE || temp == 0){
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (; temp > 0; temp /= 10) {
            stringBuilder.append(temp % 10);
        }
        if (Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE || Long.parseLong(stringBuilder.toString()) < Integer.MIN_VALUE){
            return 0;
        }
        return sign ? Integer.parseInt(stringBuilder.toString()) : -Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(0));
    }
}