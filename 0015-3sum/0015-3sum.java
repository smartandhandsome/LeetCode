class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];

                if (sum + nums[i] > 0) {
                    hi--;
                    continue;
                } 

                if (sum + nums[i] < 0) {
                    lo++;
                    continue;
                }

                ret.add(List.of(nums[lo], nums[hi], nums[i]));

                int nextLo = lo + 1;
                while (nextLo < n && nums[lo] == nums[nextLo]) {
                    nextLo++;
                }
                int nextHi = hi - 1;
                while (nextHi > 0 && nums[hi] == nums[nextHi]) {
                    nextHi--;
                }
                hi = nextHi;
                lo = nextLo;
            }
        }
        return ret;
    }
}