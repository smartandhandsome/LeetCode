class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> a = gogo(0, words, groups);
        List<String> b = gogo(1, words, groups);
        if (a.size() > b.size()) {
            return a;
        }
        return b;
    }
    
    
    public List<String> gogo(int target, String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
                
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != target) {
                result.add(words[i]);
            }
            target = groups[i];
        }
        return result;
    }
}
