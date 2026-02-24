class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetfriendarrival= times[targetFriend][0];

        Arrays.sort(times,(a,b)-> a[0]-b[0]);// sorting by arrival 

        int [] chairs = new int[times.length];// end time 

        for(int i = 0 ; i<times.length; i++){
            for(int j = 0 ; j<chairs.length;j++){
                if(times[i][0]>=chairs[j]){
                    if(targetfriendarrival==times[i][0]){
                        return j;
                    }
                    chairs[j]=times[i][1];
                    break;
                }
            }
        }
        return -1;
    }
}