from multipledispatch import dispatch
import sys
from bespoke import invariants

@dispatch(object, int, int)
def partition(arr, low, high):
    x = arr[high]

    i = low - 1

    #loop invariant - items to the left should be the lowest, items to the
    #right should be the highest
    for j in range(low, high):
        invariants.assertInvariantBool(x, arr[0:i+1], loopLookLeft)
        invariants.assertInvariantBool(x, arr[i+1:j], loopLookRight)
        if arr[j] <= x:
            i+=1 

            (arr[i], arr[j]) = (arr[j], arr[i])

    (arr[i+1], arr[high]) = (arr[high], arr[i+1])

    return i + 1

def loopLookLeft(pivot, subarray):
    for item in subarray:
        if item > pivot:
            return False

    return True

def loopLookRight(pivot, subarray):
    
    for item in subarray:
        if item <= pivot:
            return False

    return True


@dispatch(object, int, int)
def quickSort(arr, low, high):
    if low < high:
        i = partition(arr, low, high)

        quickSort(arr, low, i-1)
        
        quickSort(arr, i+1, high)




if __name__ == "__main__":
    list = [ 10, 7, 8, 9, 1, 5, -2, 6, 1, 3]
    quickSort(list, 0, len(list)-1)
    #quickSort(list)
    print(list)
