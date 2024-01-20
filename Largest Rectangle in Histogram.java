class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        Stack<Pair<Integer, Integer>> stack = new Stack<>(); // Initializing like Stack<>()!!
        for (int i = 0; i < heights.length; i++) {
            int start = i; // default index to be added will be i
            int popped = 0;
            while (!stack.isEmpty() && heights[i] < stack.peek().getValue()) { // pop all the entries which cannot be extended
                int area = (i - (stack.peek().getKey())) * stack.peek().getValue(); // Compute the area before popping
                if (area > maxArea) {
                    maxArea = area;
                }
                Pair<Integer, Integer> p = stack.pop();
                int index = p.getKey(); 
                start = index; // now poshed element will have new start of area extension
            }
                stack.push(new Pair(start, heights[i]));
        }
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> p = stack.pop();
            int width = n - (p.getKey());
            int height = p.getValue();
            int area = width * height;
            if (area > maxArea) {
                maxArea = area;
            }  
        }
        return maxArea;
    }
}
