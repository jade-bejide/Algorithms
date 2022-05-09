#O(n) solution - 1 subproblem needed to compute current value
def maxSubarray(arr):
    n = len(arr)
    
    #array to compute optimal solution via the bottom up appraoch
    m = [-1]*(n-1)
    
    m[0] = arr[0]
    q = arr[0]

    #variables to track the optimal cost
    start = 0
    end = n

    for i in range(1, n-1):
        #last solution wasn't optimal, let's try again
        if m[i-1] < 0:
            m[i] = arr[i]
            start = i
        else:
            #add to working solution
            m[i] = arr[i] + m[i-1]

        #update q to hold best solution
        q = max(q, m[i])

        #if this is current working version, update end pointer
        if q == m[i]:
            end -= 1

    return q, start, end

def printSolution(soln):
    return pp[0] + " " + str(soln[0]) + "\n" + str(pp[1]) + " " + str(soln[1]) + " " +  pp[2] + " " +  str(soln[2])


a = [-25, 20, -3, -16, -23, 18, 20, -7, 12, -5, 1]

pp = ["The optimal cost is:", "Start:", "End:"]
soln = maxSubarray(a)

print(printSolution(soln))
    
