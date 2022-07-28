import math 

def insertionSort(arr):
    swaps  = 0
    if len(arr) == 1:
        return arr
    
    if len(arr) == 2:
        if arr[0] >= arr[1]:
            return [arr[1], arr[0]]
        else:
            return arr


    n = len(arr)
    moveLeft = 0
    totalMoves = 0
    appl = 0
    bppl = 0

    for j in range(1,n):
        #print("meep")
        v = arr[j] #selects current pos in array
        i = j -1 # checks to the left of that value
        if  arr[i] > v: appl += 1
        else: bppl += 1
        while i >= 0 and arr[i] > v: #until a value greater than v is reached
            #print("moop")
            moveLeft += 1
            
            arr[i+1] = arr[i] #swaps
            i -= 1 #checks the the left again
        arr[i+1] = v #inserts v into the correct position, i+1 to negate the
                    #last i-= 1
        #print("moves left at %s is " % (j), moveLeft)
        totalMoves += moveLeft
        assert(moveLeft <= j)
        moveLeft = 0

    print(totalMoves, appl, bppl)


    return arr
    
