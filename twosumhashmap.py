from typing import List

def twoSum(self, nums: List[int], target: int) -> List[int]:
    hashtable = {}
    currentValue = nums[0]
    hashtable[nums[0]] = 0
    for i in range(1, len(nums)):
        if nums[i] + currentValue == target:
            return [hashtable[currentValue], i]
        else:
            hashtable[nums[i]] = i
            currentValue = nums[i]
