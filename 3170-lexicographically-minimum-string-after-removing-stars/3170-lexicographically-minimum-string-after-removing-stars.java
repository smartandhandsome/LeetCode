class Solution {
    public String clearStars(String s) {


        Queue<Integer> queue = new PriorityQueue<>(
            Comparator.comparing(s::charAt)
                .thenComparingInt(i -> -i)
        );

        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                removed.add(queue.poll());
                continue;
            }
            queue.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (removed.contains(i) || s.charAt(i) == '*') {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}