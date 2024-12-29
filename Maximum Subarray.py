class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # Kadane's Algorithm
        maxYet, maxNow = float("-inf"), float("-inf")
        for n in nums:
            if maxNow < 0:
                maxNow = 0
            maxNow += n
            maxYet = max(maxYet, maxNow)
        return maxYet
