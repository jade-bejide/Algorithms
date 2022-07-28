from typing import List

def getStartTimes(activities):
    return list(map(lambda x:x[0], activities))

def getFinishTimes(activities):
    return list(map(lambda x:x[1], activities))

'''
    EXPLANATION
    --------------
    1) s - start times, f - finish times, k - index of set, n -size of the
    original problem

    2) Assumes the set is sorted by monotonically increasing finish times
    3) First Call has the params s, f, 0, n

    Layman terms
    ------------
    The set always include the first value as it leaves the most time
    left to do other activities. Next we look through the set until we find
    the first start time that doesn't overlap with the current activity's
    finish time.

    Once we find it, we jump to that activity's index and repeat the process
    until the end of the list is reached. Return the list of mutually
    compatible activities afterwards.
'''
def recursiveActivitySelector(s: List[int], f: List[int], k: int, n: int):
    m = k + 1

    while m < n and s[m] < f[k]: m+= 1 #find first activity in S_{k} to finish 

    if m > n: return []

    return [[s[m], f[m]]]+recursiveActivitySelector(s, f, m, n)

def iterativeActivitySelector(s: List[int], f: List[int]):
    n = len(s)
    A = [[s[0], f[0]]]
    k = 0

    for m in range(1, n):
        if s[m] >= f[k]:
            A+=[[s[m],f[m]]]
            k = m

    return A


'''TESTS'''

test_data = [[1,4],[3,5],[0,6],[5,7],[3,9],[5,9],[6,10],[8,11],[8,12],[2,14],[12,16]]

starts = getStartTimes(test_data)
ends = getFinishTimes(test_data)

n = len(test_data)-1

assert [test_data[0]]+recursiveActivitySelector(starts, ends, 0, n) == [[1, 4], [5, 7], [8, 11], [12, 16]]
assert iterativeActivitySelector(starts, ends) == [[1, 4], [5, 7], [8, 11], [12, 16]]


    
