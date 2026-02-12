class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

       // sorting by start time 
       Arrays.sort(intervals,(a,b)-> {
        int val = Integer.compare(a[0], b[0]);
        return val==0 ? Integer.compare(b[1],a[1]):val;
        });
       
        int n= intervals.length;
        int count = 1 ; 
        int max = intervals[0][1];

        for(int i = 1 ; i<n ; i++){
            if(intervals[i][1]>max){
                count++;
                max=intervals[i][1];
            }
        }
        return  count;
    }
}