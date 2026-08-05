class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int start = intervals[0][0];
        int stop = intervals[0][1];
        int count = 0;
        
        
        for (int i = 1; i < intervals.length; i++) {
            if (stop >= intervals[i][0])
                stop = Math.max(intervals[i][1], stop);
            else {
                intervals[count][0] = start;
                intervals[count][1] = stop;
                count++;
                
                
                start = intervals[i][0];
                stop = intervals[i][1];
            }
        }
        
        
        intervals[count][0] = start;
        intervals[count][1] = stop;
        count++;
        
        
        int[][] ans = new int[count][2];
        
        
        for (int i = 0; i < count; i++)
            ans[i] = intervals[i];
        
        
        return ans;
    }
}