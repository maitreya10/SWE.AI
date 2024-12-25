class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (prevEnd > start){
                res++;
            } else {
                // Putting it in else is crucial as one long iterval could have
                // multiple intervals in it, so in that case we actuall do not need to change prevEnd
                prevEnd = end;        
            }
        }
        return res;
    }
}
