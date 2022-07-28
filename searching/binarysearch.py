def binarysearch(arr, x):
    n = len(arr)

    if n == 1:
        if arr[0] == x:
            return x
        else:
            return None

    mid = n // 2

    if arr[mid] == x:
        return x
