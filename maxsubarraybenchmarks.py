from maxsubarray import MaximumSubarray
from kadanesmaxsubarray import maxSubarray, printSolution
from benchmarks import Benchmarks


a = [100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106]
m = MaximumSubarray(a)

samples = 1000

print("Input:", a, "Sample Size:", samples)
print(Benchmarks.benchmarkFunc(maxSubarray, samples, a))
print(Benchmarks.benchmarkFunc(m.maximumSubarray, samples))
