class Solution {
    /**
     * max heap data structure using PQ.
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(20, Collections.reverseOrder());
    /**
     * min heap data structure using PQ.
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(20);
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
    for (int i = 0; i < nums1.length; i++) {
        addNumber(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
        addNumber(nums2[i]);
    } 

     // From here actual median will be returned   
     if (maxHeap.isEmpty()) {
        return 0.0;
      }
      if (maxHeap.size() == minHeap.size()) {
        return (maxHeap.peek() + (float) minHeap.peek()) / 2.0;
        
      }
      return maxHeap.peek(); 
    }
    public void addNumber(int value) {
    
      if (maxHeap.size() == minHeap.size()) {
        if (minHeap.peek() != null && value > minHeap.peek()) {
          maxHeap.offer(minHeap.remove());
          minHeap.offer(value);
        } else {
          maxHeap.offer(value);
        }
      } else {
        if (value < maxHeap.peek()) {
          minHeap.offer(maxHeap.remove());
          maxHeap.offer(value);
        } else {
          minHeap.offer(value);
        }
      }
    }
    
}
