class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int target=times[targetFriend][0];
        Arrays.sort(times,(a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        int chairno = 0 ;

        for (int []t : times){
            int arrival = t[0];
            int leave =t[1];

            while(!busy.isEmpty() && busy.peek()[0]<=arrival){
                free.add(busy.poll()[1]);
            }
            int chair;
            if(!free.isEmpty()){
                chair=free.poll();
            }else{
                chair=chairno++;
            }
            if(arrival==target){
                return chair;
            }
            busy.add(new int[]{leave,chair});
        }
        return -1;
    }
}