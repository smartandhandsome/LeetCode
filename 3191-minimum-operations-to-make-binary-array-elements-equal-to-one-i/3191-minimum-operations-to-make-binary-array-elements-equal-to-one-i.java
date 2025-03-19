class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        int i = 0;
        while(i + 2 < nums.length) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = convert(nums[i + 1]);
                nums[i + 2] = convert(nums[i + 2]);
                count++;
            }
            i++;
        }
        if (nums[i] == 1 && nums[i + 1] == 1) {
            return count;
        }
        return -1;
    }

    public int convert(int n) {
        return n == 1 ? 0 : 1;
    }
}