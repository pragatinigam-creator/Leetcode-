import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            
            if(temp.next != null){
                pq.add(temp.next);
            }
        }
        
        return dummy.next;
    }
}