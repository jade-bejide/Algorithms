#O(n) solution - 1 subproblem needed to compute current value
def maxSubarray(arr):
    n = len(arr)
    
    #array to compute optimal solution via the bottom up appraoch
    m = [-1]*n
    
    m[0] = arr[0]
    q = arr[0]

    #variables to track the optimal cost
    start = 0
    end = n

    for i in range(0, n):
        #last solution wasn't optimal, let's try again
        if m[i-1] <= 0:
            m[i] = arr[i]
            start = i
        else:
            #add to working solution
            m[i] = arr[i] + m[i-1]

        #update q to hold best solution
        q = max(q, m[i])

        #if this is current working version, update end pointer
        if q == m[i]:
            end = i

    if start > end:
        start-=1

    return q, start, end

def printSolution(soln):
    print(pp[0] + " " + str(soln[0]) + "\n" + str(pp[1]) + " " + str(soln[1]) + " " +  pp[2] + " " +  str(soln[2]))
    

##a = [-25, 20, -3, -16, -23, 18, 20, -7, 12, -5, 1]
##a2 = [100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106]
##a3 = [-2, -4]
##
##pp = ["The optimal cost is:", "Start:", "End:"]
##soln = maxSubarray(a)
##soln2 = maxSubarray(a2)
##soln3 = maxSubarray(a3)
##
##printSolution(soln)
##printSolution(soln2)
##printSolution(soln3)
    
