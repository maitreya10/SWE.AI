class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        x = y = z = False  # These booleans track whether we've satisfied each of the three target positions

        for t in triplets:
            # If t[0] matches target[0] and the other two components are not larger than target's,
            # we can fulfill the first element of the target
            x |= (t[0] == target[0] and t[1] <= target[1] and t[2] <= target[2])

            # If t[1] matches target[1] and the other two components are not larger than target's,
            # we can fulfill the second element of the target
            y |= (t[0] <= target[0] and t[1] == target[1] and t[2] <= target[2])

            # If t[2] matches target[2] and the other two components are not larger than target's,
            # we can fulfill the third element of the target
            z |= (t[0] <= target[0] and t[1] <= target[1] and t[2] == target[2])

            # Once we've satisfied all three target elements, we can stop
            if x and y and z:
                return True

        return False
