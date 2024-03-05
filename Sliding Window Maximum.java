/**
 * The concept of Window is abstract in this case.
 * i just goes from 0 to len-1 , n while doing so it adjusts the Deque on its way with the help of the While loop. 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length + 1 - k];
        int j = 0;
        // Store index
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k.
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            // maintain Strictly decreasing Queue, remove Smaller Numbers.
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            // initially we keep adding until i 
            q.offer(i);
            // Now at This point deque is rearranged and 
            // we can add the elements in the output array only after when i is greater than the initial window
            // see case 1 of notebook.
            // This also ensures we are filling the output array exactly by its size (i.e nums.length - k + 1)
            // Start filling the output array from when i >= k-1.
            if (i >= k - 1 ) {
                ans[j++] = nums[q.peekFirst()]; 
            }
        }
        return ans;
    }
}
