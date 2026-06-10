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
    public ListNode help(ListNode head, int sz, int i, int k){
        ListNode curr = head;
        if(i+k > sz) return head;
        else{
            ListNode next = head.next;
            ListNode prev = head;
            for(int j=1; j<k; j++){
                curr = next;
                next = next.next;
                curr.next = prev;
                prev = curr;
            }
            head.next = help(next, sz, i+k, k);
            if(i == 0) head = curr;

        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode curr = head;
        int sz=0;
        while(curr != null){
            sz++;
            curr = curr.next;
        }
        
        return help(head, sz, 0, k);
    }
}