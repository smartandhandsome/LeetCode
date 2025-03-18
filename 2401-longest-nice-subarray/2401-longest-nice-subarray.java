class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int right = 1;

        int answer = 1;
        int bitMask = nums[left];
        while (right < nums.length && left <= right) {
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left];
                left++;
            }

            bitMask |= nums[right];
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}
