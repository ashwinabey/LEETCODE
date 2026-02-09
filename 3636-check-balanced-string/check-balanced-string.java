class Solution {
    public boolean isBalanced(String num) {
        int evensum=0;
        int oddsum=0;

        for(int i =0 ; i<num.length();i++){
            if(i%2==0){
                evensum+=num.charAt(i)-'0';
            }
            else{
                oddsum+=num.charAt(i)-'0';
            }
        }
        return oddsum==evensum;
    }
}