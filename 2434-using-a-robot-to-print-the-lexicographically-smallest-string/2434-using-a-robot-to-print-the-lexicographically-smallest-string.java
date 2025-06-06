class Solution {
    public String robotWithString(String s) {
        Queue<Integer> indexes = new PriorityQueue<>(
                Comparator.comparingInt(s::charAt)
                        .thenComparingInt(o -> o)
        );

        for (int i = 0; i < s.length(); i++) {
            indexes.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int cur = 0;
        Stack<Character> stack = new Stack<>();
        while (!indexes.isEmpty()) {
            int index = indexes.poll();
            // System.out.println("cur = " + cur + ", index = " + index);
            if (index < cur) {
                while (!stack.isEmpty() && s.charAt(index) - 'a' >= stack.peek() - 'a') {
                    sb.append(stack.pop());
                }
                continue;
            }

            for (int i = cur; i < index; i++) {
                stack.push(s.charAt(i));
            }
            cur = index + 1;
            sb.append(s.charAt(index));
            // System.out.println("move cur = " + cur);
            // System.out.println("sb: " + sb + ", stack: " + stack);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

