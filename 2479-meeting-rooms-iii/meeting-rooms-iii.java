class Solution {
    public int mostBooked(int n, int[][] meetings) {
         Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        long[] end = new long[n];
        int[] count = new int[n];

        for(int i = 0; i < meetings.length; i++){

            int starttime = meetings[i][0];
            int endtime = meetings[i][1];

            boolean roomallocated = false;
            int minEndTimeIdx = 0;

            for(int room = 0; room < n; room++){

                if(starttime >= end[room]){
                    end[room] = endtime;
                    count[room]++;
                    roomallocated = true;
                    break;
                }

                if(end[room] < end[minEndTimeIdx]){
                    minEndTimeIdx = room;
                }
            }

            if(!roomallocated){
                end[minEndTimeIdx] = end[minEndTimeIdx] + (endtime - starttime);
                count[minEndTimeIdx]++;
            }
        }

        int maxRoomCountsIdx = 0;

        for(int i = 0; i < n; i++){
            if(count[i] > count[maxRoomCountsIdx]){
                maxRoomCountsIdx = i;
            }
        }

        return maxRoomCountsIdx;
    }
}