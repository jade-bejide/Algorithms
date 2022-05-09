import timeit
import time
from typing import Optional, List
import statistics as s

class Benchmarks(object):
    #params - func (function), Optional[val (function param)], n (no. samples)
    
    @staticmethod
    def benchmarkFunc(func, n, val=None):
        results = [-1]*n
        avgTime = 0

        for i in range(n):
            start = timeit.default_timer()
            if val != None: func(val)
            else: func()
            
            results[i] = timeit.default_timer() - start

        avgTime = s.mean(results)
        sd = s.stdev(results)

        return "Approach: " + func.__name__ + "\nAverage Time Taken: " + str(avgTime) +"\nStandard Deviation: " + str(sd) + "\n"
