class Solution(object):
    def isPalindrome(self, s):
        low = 0
        high = len(s) - 1
        while low < high:
            lowC = s[low].lower()
            highC = s[high].lower()
            if ('a' > lowC or lowC > 'z') and not ('0' <= lowC <= '9'):
                low += 1
                continue
            if ('a' > highC or highC > 'z') and not ('0' <= highC <= '9'):
                high -= 1
                continue

            if lowC != highC:
                return False
            low += 1
            high -= 1
        return True