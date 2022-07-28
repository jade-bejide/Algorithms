def fn(arr):
  import math
  return quicksort(arr, 0, len(arr)-1)
  
def partition(arr, low, pivot):
  n = len(arr)
  x = arr[pivot]
  i = low-1
  for j in range(0, n):
    if arr[j] <= x:
      i += 1
      arr[i], arr[j] = arr[j], arr[i]
      
  (arr[i+1], arr[pivot]) = (arr[pivot], arr[i+1])
  
  return (i + 1)
  
def quicksort(arr, low, high):
  if low < high:
    i = partition(arr, low, low+4)
    quicksort(arr, 0, i)
    quicksort(arr[i+1:high])
  
  return arr

  
if __name__ == "__main__":
    list = [ 10, 7, 8, 9, 1, 5, -2, 6, 1, 3]
    quicksort(list, 0, len(list)-1)
    #quickSort(list)
    print(list)