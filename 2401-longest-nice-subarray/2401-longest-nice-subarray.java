class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int right = nums.length;

        int answer = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(nums, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean check(int[] nums, int mid) {
        for (int start = 0; start + mid <= nums.length; start++) {
            int my = 0;
            boolean isNice = true;
            for (int i = start; i - start < mid; i++) {
                if ((my & nums[i]) != 0) {
                    isNice = false;
                    break;
                }
                my |= nums[i];
            }
            if (isNice) {
                return true;
            }
        }
        return false;
    }
}