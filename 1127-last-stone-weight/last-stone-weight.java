class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();

        for(int stone : stones){
            list.add(stone);
        }
        while(list.size()>1){
            Collections.sort(list);

            int s1=list.remove(list.size()-1);
            int s2=list.remove(list.size()-1);

            if(s1==s2){
                continue;
            }
            list.add(s1-s2);

        }
        return list.size()==0 ? 0 :list.get(0);
    }
}