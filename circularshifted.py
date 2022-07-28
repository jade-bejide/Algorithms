import math
def circular(arr, l, r):
    

    arr = arr[l:r+1]
    n = len(arr)
    
    for q in range(0, n):
        l = 0
        r = n -1 
        p = math.floor

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


    
