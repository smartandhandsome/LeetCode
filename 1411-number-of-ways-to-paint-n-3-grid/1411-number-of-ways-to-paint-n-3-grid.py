class Solution:
    def numOfWays(self, n: int) -> int:
        pattern_a = 6
        pattern_b = 6

        for i in range(1, n):
            pattern_a_new = (2 * pattern_a + 2 * pattern_b) % (10 ** 9 + 7)
            pattern_b_new = (2 * pattern_a + 3 * pattern_b) % (10 ** 9 + 7)

            pattern_a = pattern_a_new
            pattern_b = pattern_b_new

        return (pattern_a + pattern_b) % (10 ** 9 + 7)

