import maxsubarray as method1
import kadanesmaxsubarray as method2
from benchmarks import Benchmarks


a = [100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106]

samples = 20000

print("Input:", a, "Sample Size:", samples)
print(Benchmarks.benchmarkFunc(method1.findMaxSubarray, samples, a, 0, len(a)-1))
print(Benchmarks.benchmarkFunc(method2.maxSubarray, samples, a))
