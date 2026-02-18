/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int probgroupsize=1;
        //finding length 
        int len = 0;
        ListNode curr=head;

        while(curr!=null){
            len++;
            curr=curr.next;
        }
        curr=head;

        ListNode p=null;

        while(curr!=null){
            int actualgroupsize=Math.min(probgroupsize, len);

            //processing (finding if groupsize is even or not )
            if(actualgroupsize%2==0){
                // reverse 
                ListNode prev = null;
                ListNode temp = curr;
                int counter = 0;

                while(counter<actualgroupsize){
                    counter++;

                    ListNode next =curr.next;

                    curr.next=prev;
                    prev=curr;
                    curr=next;
                }
                //linking 
                p.next=prev;
                temp.next=curr;

                p=temp;
            }else{
                // skip 

                int counter = 0 ;
                while(counter<actualgroupsize){
                    counter++;
                    p=curr;
                    curr=curr.next;
                }
            }
            probgroupsize++;
            len=len-actualgroupsize;
        }
        return head;
        
    }
}