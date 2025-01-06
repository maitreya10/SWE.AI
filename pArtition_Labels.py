class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}
        
        # 1. Record the last occurrence of each character.
        #    For example, if s = "abaccb", then:
        #    lastIndex = {'a': 2, 'b': 5, 'c': 4}
        #    because 'a' last appears at index 2, 'b' at index 5, and 'c' at index 4.
        for i, c in enumerate(s):
            lastIndex[c] = i
        
        res = []      # This will store the sizes of each partition.
        size = 0      # Tracks the current partition size.
        end = 0       # Tracks the furthest lastIndex within the current partition.
        
        # 2. Traverse the string to form partitions.
        for i, c in enumerate(s):
            size += 1                 # Include the current character in the current partition.
            end = max(end, lastIndex[c])  
            # Update 'end' to be the furthest last occurrence of any character seen so far 
            # in the current partition.
            
            # 3. If we reach 'end', it means all characters in the current partition
            #    won't appear beyond this index, so we can "cut" the partition here.
            if i == end:
                res.append(size)  # Append the size of this partition.
                size = 0          # Reset size for the next partition.
        
        return res
