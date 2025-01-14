class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int[] ret = new int[A.length];

        setA.add(A[0]);
        setB.add(B[0]);
        if (A[0] == B[0]) {
            ret[0] = 1;
        }

        for (int i = 1; i < A.length; i++) {
            setA.add(A[i]);
            setB.add(B[i]);

            if (A[i] == B[i]) {
                ret[i] = ret[i - 1] + 1;
                continue;
            }

            System.out.println(setA);
            System.out.println(setB);

            System.out.println(setB.contains(A[i]) ? 1 : 0);
            System.out.println(setA.contains(B[i]) ? 1 : 0);
            ret[i] = ret[i - 1] + (setB.contains(A[i]) ? 1 : 0) + (setA.contains(B[i]) ? 1 : 0);

        }
        return ret;
    }
}