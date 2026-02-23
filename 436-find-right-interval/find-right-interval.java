class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int len = intervals.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int min = -1;

            for (int j = 0; j < len; j++) {
                
                if (intervals[j][0] >= intervals[i][1]) {
                    if (min == -1) {
                        min = j;
                    } 
                    else if (intervals[j][0] < intervals[min][0]) {
                        min = j;
                    }
                }
            }

            res[i] = min;
        }

        return res;
    }
}