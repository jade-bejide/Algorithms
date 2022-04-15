from math import floor

class MaximumSubarray(object):
    def __init__(self, arr):
        self.__arr = self.computeDeltas(arr)
        print(self.__arr)
        self.__n = len(arr)
        
    def crossesMidPointIndices(self, arr):
        maxi = arr[0]
        i = 0
        n = len(arr)
        total = 0

        for j in range(1, n):
            total = total  + arr[j]
            if total > maxi:
                i += 1
                maxi = total
            else:
                total = 0

        return i

    def crossesMidPoint(self):
        findingI = self.__arr[0:floor(self.__n/2)]
        findingJ = self.__arr[floor(self.__n/2):self.__n]

        i = self.crossesMidPointIndices(findingI)
        j = self.crossesMidPointIndices(findingJ)

        total = 0

        for pos in range(i, j+1):
            total += self.__arr[pos]

        return i, (j+floor(self.__n/2)), total

    def inLeftOrRight(self, start, end, isLeft):
        arr = self.__arr[start:end]
        n = len(arr)
        total = 0
        maxi = -float("inf")
        indexS = 0
        indexE = 0

        for i in range(0, n):
            total += arr[i]
            if isLeft: print("current:", arr[i], "working total:",total, "max:", maxi)
            if total > maxi and total > 0:
                maxi = total
                indexE += 1
            else:
                if total < 0:
                    total = 0
                if total < maxi: indexS = indexE

        if isLeft: return indexS, indexE, maxi
        else: return n+indexS, indexE+n+floor(n/2)+1, maxi
    
    def computeDeltas(self, arr):
        i = 0
        while (i < len(arr)-1):
            arr[i] = arr[i+1]-arr[i]
            i += 1

        return arr[0:len(arr)-1]

    def maximumSubarray(self):
        if self.__n == 1:
            return self.__arr
        
        left = self.inLeftOrRight(0, floor(self.__n/2), True)
        middle = self.crossesMidPoint()
        right = self.inLeftOrRight(floor(self.__n/2), self.__n, False)
        print("Left: ", left)
        print("Middle: ", middle)
        print("Right: ", right)

        if left[2] > middle[2]:
            if left[2] > right[2]:
                return left

        if middle[2] > right[2]:
            return middle
        return right

a1 = [100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106]
a2 = [-13, -3, -25, -20, -3, -16, -23, -12, -5, -22, -15, -4, -7]
m1 = MaximumSubarray(a1)
m2 = MaximumSubarray(a2)

print(m1.maximumSubarray())
print(m2.maximumSubarray())
