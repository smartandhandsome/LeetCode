class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(tops[0], 1);
        for (int i = 1; i < length; i++) {
            if ((tops[i] != tops[0] && bottoms[i] != tops[0]) &&
                    (tops[i] != bottoms[0] && bottoms[i] != bottoms[0])) {
                return -1;
            }
            map.merge(tops[i], 1, Integer::sum);
        }
        return Math.min(
                Math.min(map.getOrDefault(tops[0], length), length - map.getOrDefault(tops[0], 0)),
                Math.min(map.getOrDefault(bottoms[0], length), length - map.getOrDefault(bottoms[0], 0))
        );
    }
}