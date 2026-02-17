class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int uniform = len / k;   
        int rem = len % k;       

        ListNode[] res = new ListNode[k];
        curr = head;

        
        for (int i = 0; i < k; i++) {
            
            ListNode temp = curr;
            int partSize = uniform + (rem > 0 ? 1 : 0);
            
            if (rem > 0) rem--;

            ListNode prev = null;

            for (int j = 0; j < partSize; j++) {
                prev = curr;
                if (curr != null)
                    curr = curr.next;
            }

            if (prev != null)
                prev.next = null;

            res[i] = temp;
        }

        return res;
    }
}
