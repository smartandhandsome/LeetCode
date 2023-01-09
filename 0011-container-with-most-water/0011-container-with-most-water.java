class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                answer = Math.max((right - left) * (height[right]), answer);
                right--;
            } else {
                answer = Math.max((right - left) * (height[left]), answer);
                left++;
            }
        }
        return answer;
    }
}