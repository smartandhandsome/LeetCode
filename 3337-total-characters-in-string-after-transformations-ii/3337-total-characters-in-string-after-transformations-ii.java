import java.util.List;

class Solution {
    static int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[][] matrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                matrix[i][(i + j) % 26]++;
            }
        }

        int[][] multipliedMatrix = matrixPower(matrix, t);

        long answer = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                answer = (answer + (long) count[j] * multipliedMatrix[j][i] % MOD) % MOD;
            }
        }
        return (int) answer;
    }

    public int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }

        int[][] base = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                base[i][j] = matrix[i][j];
            }
        }

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMultiply(result, base);
            }
            base = matrixMultiply(base, base);
            power /= 2;
        }

        return result;
    }
    
    private int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] c = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    c[i][j] = (int) (((long) c[i][j] + (long) a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return c;
    }
}