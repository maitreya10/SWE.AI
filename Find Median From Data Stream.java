class MedianFinder {
    /**
     * max heap data structure using PQ.
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * min heap data structure using PQ.
     */
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(20, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(20);
    }
     /**
     * Adds int values into two heaps.
     * It should maintain a condition that maxHeap.size() >= minHeap.size().
     * We can imagine it as 2 lists(heaps) side by side : (elements in MaxHeap(but reverse so right-most element is max on this set)) (Elements in min Heap (left most element is minimum of this set)
     * hence this design makes sure that all elements in the maxHeap are smaller than the elements in the minHeap.
     * @param value int value to add
     */
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && num > minHeap.peek()) {
                maxHeap.offer(minHeap.remove());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (num < maxHeap.peek()) {
                minHeap.offer(maxHeap.remove());
                maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
      }
    }
    
    /**
     * Returns the median value of the added values.
     * If maxHeap and minHeap are of different sizes, then maxHeap must have one extra element.
     * @return median value
     */
    public double findMedian() {
        if (maxHeap.isEmpty()) {
        return 0.0;
      }
      if (maxHeap.size() == minHeap.size()) {
        return (maxHeap.peek() + (float) minHeap.peek()) / 2.0;
        
      }
      return maxHeap.peek(); 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
