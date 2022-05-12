import math
def circular(arr, l, r):
    arr = arr[l:r+1]
    n = len(arr)

    p = math.floor((l+r)/ 2)-1
    if arr[(p+1) % n] < arr[p]:
        return (p+1) % n
    if arr[l] >= arr[p]:
        circular(arr, l, p-1) 
    elif arr[l] < arr[p]:
        circular(arr, p+1, r)

k2 = [35,42,5,15,27,29]
k4 = [27,29,35,42,5,15]
k1 = [42, 5, 15, 27, 29]
k0 = [5, 15, 27, 29, 42]
k3 = [29,35,42,5,15,27]

print(circular(k0, 0, 4))
print(circular(k1, 0, 4))
print(circular(k2, 0, 4))
print(circular(k3, 0, 4))
print(circular(k4, 0, 4))


    
