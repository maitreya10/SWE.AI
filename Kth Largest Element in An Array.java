class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a Min Heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // Iterate over the Array.
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                // remove root, i.e the lowest of them all.
                minHeap.remove(); // remove() is the method of the PQ class, poll() is the method of the Queue Interface, both can be used.
            }
        }
        // now the minimum present in the minHeap will be the Kth largest element.
        return minHeap.peek();
    }
}
