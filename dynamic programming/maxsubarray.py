from math import floor

def findMaxCrossingSubarray(arr, low, mid, high):
    maxLeft = 0
    maxRight = 0

    #adjust left pointer to maximise subarray
    leftSum = - float("inf")
    sum_ = 0
    for i in range(mid, low-1, -1):
        sum_ += arr[i]
        if sum_ > leftSum:
            leftSum = sum_
            maxLeft = i

    #adjust right pointer to maximise subarray
    rightSum = -float("inf")
    sum_ = 0
    for j in range(mid+1, high+1):
        sum_ += arr[j]
        if sum_ > rightSum:
            rightSum = sum_
            maxRight = j

    #return both pointers and the value of the maximised crossing point
    return (maxLeft, maxRight, leftSum + rightSum)

def findMaxSubarray(arr, low, high):
    if high == low:
        return (low, high, arr[low])
    else:
        mid = (low+high)//2

        (leftLow, leftHigh, leftSum) = findMaxSubarray(arr, low, mid)
        (rightLow, rightHigh, rightSum) = findMaxSubarray(arr, mid+1, high)
        (crossLow, crossHigh, crossSum)= findMaxCrossingSubarray(arr, low, mid, high)

        if leftSum >= rightSum and leftSum >= crossSum:
            return (leftLow, leftHigh, leftSum)
        elif rightSum >= leftSum and rightSum >= crossSum:
            return (rightLow, rightHigh, rightSum)
        else:
            return (crossLow, crossHigh, crossSum)

a = [-25, 20, -3, -16, -23, 18, 20, -7, 12, -5, 1]
a2 = [-25,-23,-24,-25]
print(findMaxSubarray(a, 0, len(a)-1))
print(findMaxSubarray(a2, 0, len(a2)-1))
            
