class KthLargest {
    final PriorityQueue<Integer> heap = new PriorityQueue<>();
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k; // set the instance variable as value of k.
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        // add values of the array only till size k is maintained.
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) { // we add item only when its value is greater than the current minimum in the heap.
            // Because if it smaller than the min of the minheap, it has nothing to do with the k largest elements in the minheap.
            heap.poll(); // remove min element of the minheap.
            heap.add(val); // add the current item.
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
