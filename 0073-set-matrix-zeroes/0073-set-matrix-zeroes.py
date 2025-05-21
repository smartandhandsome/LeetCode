class Solution(object):
    def setZeroes(self, matrix):
        row = set()
        col = set()
        n = len(matrix)
        m = len(matrix[0])
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    row.add(i)
                    col.add(j)
        for i in row:
            for j in range(m):
                matrix[i][j] = 0

        for i in col:
            for j in range(n):
                matrix[j][i] = 0                
        return matrix