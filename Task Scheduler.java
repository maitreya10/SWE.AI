class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length; //n == 0 means we have no restriction, and we can use any task any time.(Guaranteed 0 idle time).
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // define a lambda function for the PQ to work as a Max Heap.
        Queue<Pair<Integer, Integer>> q = new LinkedList<>(); // Polymorphism (Interface -> class).
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++; // increase the frequency of the corresponding letter of the Alphabet.
        }
        for (int val : arr) {
            if (val > 0) { // add in maxHeap only if frequency is > 0.
            maxHeap.add(val); // Heapify.(build the heap).
            }
        }
        int time = 0; // set time = 0 before we start the task scheduling.
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++; // if any one of the queues is non empty we have some sheduling to do, so lets do it by incrementing the time.
            if (!maxHeap.isEmpty()) {
                int val = maxHeap.poll();
                val--; // decrement the frequency.
                if (val > 0 ) { // only if val > 0 we need the q.
                    q.add(new Pair(val, time + n)); // see the LC notebook for algorithm.
                } 
            }

            if (!q.isEmpty() && q.peek().getValue() == time) {
                maxHeap.add(q.poll().getKey());
            }
        }
        return time;
    }
}
