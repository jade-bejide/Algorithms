from benchmarks import Benchmarks
        
def recursiveFib(n):
    if n <= 1:
        return n

    return recursiveFib(n-1) + recursiveFib(n-2)

def dpFib(n):
    if n <= 1:
        return n

    a = [-1]*n
    a[0] = 1
    a[1] = 1

    for i in range(2, n):
        a[i] = a[i-1] + a[i-2]

    return a[n-1]

def dpFibImpr(n):
    if n <= 1:
        return n

    a = 0
    b = 1
    for i in range(2, n):
        c = a + b
        a = b
        b = c
    return c

n = 20
samples = 1000

print("Input:", n, "Sample Size:", samples, n)
print(Benchmarks.benchmarkFunc(dpFib, samples, n))
print(Benchmarks.benchmarkFunc(dpFibImpr, samples, n))


n = 15
samples = 100000

print("Input:", n, "Sample Size:", samples)
print(Benchmarks.benchmarkFunc(recursiveFib, samples, n))
print(Benchmarks.benchmarkFunc(dpFib,samples, n))
print(Benchmarks.benchmarkFunc(dpFibImpr,samples, n))    
