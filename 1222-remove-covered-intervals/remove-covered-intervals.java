class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int count = 0;
        int n= intervals.length;
        for(int i = 0 ; i<n ; i=i+1){
            int c = intervals[i][0];
            int d = intervals[i][1];
            boolean isCovered=false;

            for (int j = 0 ; j<n ; j=j+1){

                int a = intervals[j][0];
                int b =intervals[j][1];

                if(i!=j && (a<=c && b>=d)){
                    isCovered=true;
                    break;
                }
            }
            if(!isCovered){
                count=count+1;
            }
        }
        return count;
    }
}