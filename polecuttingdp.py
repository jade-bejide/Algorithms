class PoleCuttingDp(object):
    def __init__(self, prices, n): #n - size of pole
        self.__prices = prices
        self.__n = n

    def bottomUpCutPole(self):
        r = [None]*(self.__n+1)
        r[0] = 0
        for j in range(1, self.__n+1):
            q = -float("inf")
            for i in range(j):
                q = max(q, self.__prices[i] + r[j-i-1])
            r[j] = q
        return r[self.__n]

    def memoizedCutPoleAux(self, p, n, r):
        if r[n] >= 0:
            return r[n]

        if n == 0:
            q = 0
        else:
            q = -float("inf")
            for i in range(1, n):
                q = max(q, p[i] + self.memoizedCutPoleAux(p, n-i-1, r))
        r[n] = q
        return q

    def memoizedCutPole(self):
        r = [None]*(self.__n+1)
        for i in range(0, self.__n+1):
            r[i] = -float("inf")
        return self.memoizedCutPoleAux(self.__prices, self.__n, r)


p1 = [1,5,8,9,10,17,17,20,24,30]

solns = PoleCuttingDp(p1, 10)
solns2 = PoleCuttingDp(p1, 5)
print(solns.bottomUpCutPole())
print(solns2.bottomUpCutPole())
print(solns.memoizedCutPole())
