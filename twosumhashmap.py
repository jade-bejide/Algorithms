from typing import List

def twoSum(self, nums: List[int], target: int) -> List[int]:
    hashtable = {}
    
    for i in range(0, len(nums)):
        diff = target - nums[i]
        if diff in hashtable and hashtable[diff]!=i:
            return [i, hashtable[diff]]
        else:
            if nums[i] in hashtable:
                hashtable[nums[i]] = i+1
            else:
                hashtable[nums[i]] = i
