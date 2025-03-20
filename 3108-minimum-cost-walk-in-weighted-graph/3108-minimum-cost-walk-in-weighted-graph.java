class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int[] edge : edges) {
            union(root, edge[0], edge[1]);
            minCost[find(root, edge[0])] &= edge[2];
        }
        int[] answer = new int[query.length];
        Arrays.fill(answer, -1);
        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];
            int q0 = find(root, q[0]);
            int q1 = find(root, q[1]);
            if (q0 != q1) {
                answer[i] = -1;
                continue;
            }
            answer[i] = minCost[q0];
        }
        return answer;
    }

    private void calc(int i) {

    }

    int find(int[] root, int v) {
        if (root[v] == v) {
            return v;
        }
        return find(root, root[v]);
    }

    void union(int[] root, int v1, int v2) {
        int root1 = find(root, v1);
        int root2 = find(root, v2);
        if (root1 < root2) {
            root[root2] = root1;
        } else {
            root[root1] = root2;
        }
    }
}
