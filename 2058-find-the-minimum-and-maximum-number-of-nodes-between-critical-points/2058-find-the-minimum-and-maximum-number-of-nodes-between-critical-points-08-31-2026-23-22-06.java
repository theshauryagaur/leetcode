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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next == null || head.next.next == null || head.next.next.next == null) return new int[]{-1,-1};
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int firstPt = -1;
        int prevPt = -1;

        int min = 1000000, max = -1;
        int i=0;
        while(next != null){
            if((curr.val > next.val && curr.val > prev.val) || (curr.val < next.val && curr.val < prev.val)){
                if(firstPt == -1){
                    firstPt = i;
                    prevPt = i;
                }else{
                    min = Math.min(min, i-prevPt);
                    max = i-firstPt;
                    prevPt = i;
                }
            }
            prev = curr;
            curr = next;
            next = next.next;
            // System.out.println(firstPt+" "+prevPt);
            i++;
        }
        if(min == 1000000) return new int[]{-1,-1};
        return new int[]{min,max};
    }
}