from multipledispatch import dispatch

@dispatch(object, int, int)
def partition(arr, low, high):
    x = arr[high]

    i = low - 1

    for j in range(low, high):
        if arr[j] <= x:
            i+=1 

            (arr[i], arr[j]) = (arr[j], arr[i])

    (arr[i+1], arr[high]) = (arr[high], arr[i+1])

    return i + 1

@dispatch(object, int, int)
def quickSort(arr, low, high):
    if low < high:
        i = partition(arr, low, high)

        quickSort(arr, low, i-1)
        quickSort(arr, i+1, high)




if __name__ == "__main__":
    list = [ 10, 7, 8, 9, 1, 5, -2, 6, 1, 3, 10.6, 10.55]
    quickSort(list, 0, len(list)-1)
    #quickSort(list)
    print(list)
