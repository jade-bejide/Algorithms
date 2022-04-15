def insertionSort(arr):
    if len(arr) == 1:
        return arr
    
    if len(arr) == 2:
        if arr[0] >= arr[1]:
            return [arr[1], arr[0]]
        else:
            return arr


    n = len(arr)

    for j in range(1,n):
        v = arr[j] #selects current pos in array
        i = j -1 # checks to the left of that value
        while i >= 0 and arr[i] > v: #until a value grater than v is reached
            arr[i+1] = arr[i] #swaps
            i -= 1 #checks the the left again
        arr[i+1] = v #inserts v into the correct position, i+1 to negate the
                    #last i-= 1

    return arr
        
l1 = [1,2,3,4,5]
l2 = [5,4,3,2,1]

if (l1 == insertionSort(l2)):
    print("yippee")
