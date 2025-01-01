class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        # 1. If the total number of cards is not divisible by groupSize,
        #    it's impossible to split them into groups of equal size.
        if len(hand) % groupSize != 0:
            return False
        
        # 2. Count the frequency of each card value in 'hand'.
        #    For example, if hand = [1,2,2,3], count = {1:1, 2:2, 3:1}.
        count = Counter(hand)
        
        # 3. Iterate through each card in the original 'hand'.
        #    We'll use 'num' as a reference point for adjusting 'start'.
        for num in hand:
            # 4. Set 'start' to the current card value.
            start = num
            
            # 5. Move 'start' backward to find the lowest possible consecutive
            #    start. For example, if 'num' is 6 but there's a 5 in the counter,
            #    it means a group might actually start at 5 or lower.
            #    This loop continues until there's no card (start-1) in 'count'.
            while count[start - 1]:
                start -= 1
            
            # 6. Now that we've found a potential starting point, we'll move
            #    from 'start' up to 'num'. For each possible starting point in that
            #    range, try to form full consecutive groups of size 'groupSize'.
            while start <= num:
                # 7. As long as there are cards of value 'start' left (count[start] > 0),
                #    form a group from 'start' to 'start + groupSize - 1'.
                while count[start]:
                    # 8. Attempt to use one card of each consecutive value from 'start'
                    #    to 'start + groupSize - 1'. If any card in that range doesn't exist,
                    #    we immediately return False.
                    for i in range(start, start + groupSize):
                        if not count[i]:
                            return False
                        count[i] -= 1  # "Use" one card of value i
                
                # 9. Increment 'start' by 1 and try again (in case multiple groups can
                #    start at the same lower boundary). Eventually, 'start' will surpass
                #    'num', ending this inner while loop.
                start += 1
        
        # 10. If we've successfully formed groups without running out of consecutive cards
        #     at any point, we return True.
        return True

            
        
