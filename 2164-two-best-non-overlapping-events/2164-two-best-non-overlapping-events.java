class Solution {
    public int maxTwoEvents(int[][] events) {

        int[][] es = new int[events.length * 2][3];
        for (int i = 0; i < events.length; i++) {
            es[i * 2] = new int[] {events[i][0] - 1, events[i][2], 0};
            es[i * 2 + 1] = new int[] {events[i][1], events[i][2], 1};
        }
        Arrays.sort(
            es,
            (a, b) -> a[0] == b[0] ?
                -Integer.compare(a[2], b[2]) : Integer.compare(a[0], b[0])
        );
        
        int max = 0;
        int answer = 0;
        for (int[] e : es) {
            if (e[2] == 0) {
                answer = Math.max(answer, e[1] + max);
            }
            if (e[2] == 1) {
                max = Math.max(max, e[1]);
            }

        }
        return answer;
    }

}