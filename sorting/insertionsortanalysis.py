from insertionsort import insertionSort
import math

input_ = []
ones = 0

def logn(x, n):
    return math.log(x, n)

def isPowerOfTwo(n):
    return (math.ceil(logn(n, 2)) == math.floor(logn(n, 2)))

def isPowerOfThree(n):
    return (math.ceil(logn(n, 3)) == math.floor(logn(n, 3)))

for i in range(1, 51):
    if isPowerOfTwo(i):
        input_.append(1)
    else:
        input_.append(i)
    if input_[i-1] == 1:
        ones += 1

insertionSort(input_)



n = [10, 50, 1000, 200000]

def doTheThing(n):
    input1 = []
    for i in range(1,n+1):
        if isPowerOfThree(i):
            input1.append(n-i)
        else:
            input1.append(i)


    insertionSort(input1)   

for elem in n:
    doTheThing(elem)

