class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;

        int low = 0;
        int high = 2;

        int[][] answer = new int[n / 3][3];
        while (high < n) {
            if (nums[high] - nums[low] > k) {
                return new int[0][0];
            }

            answer[low / 3][0] = nums[low];
            answer[low / 3][1] = nums[low + 1];
            answer[low / 3][2] = nums[high];
            low += 3;
            high += 3;
        }

        return answer; 
    }  
}