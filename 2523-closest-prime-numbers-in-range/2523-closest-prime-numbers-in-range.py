class Solution:
    def getPrimes(self, low: int, high: int) -> List[bool]:
        sieve: List[bool] = [True] * (high + 1)
        sieve[0] = False
        sieve[1] = False
        for i in range(2, int(math.sqrt(high)) + 1):
            if (not sieve[i]):
                continue
            for num in range(i * i, high + 1, i):
                sieve[num] = False
        return [i for i in range(low, high + 1) if sieve[i]]

    def closestPrimes(self, left: int, right: int) -> List[int]:
        answer: List[bool] = [-1, -1]
        primes = self.getPrimes(left, right)
        if (len(primes) < 2):
            return answer
        
        for i in range(len(primes) - 1):
            if answer[0] == -1 and answer[1] == -1 or \
                answer[1] - answer[0] > primes[i + 1] - primes[i]:
                answer[0] = primes[i]
                answer[1] = primes[i + 1]
        return answer
