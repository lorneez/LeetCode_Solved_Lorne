/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Runtime complexity: O(n) where n is the length of the longest number
 * Space complexity: O(1)
 * AddTwoNumbers analyzes two ListNodes using a while loop. As long as both of the lists are not empty,
 * the while loop will continue adding the values, taking the carry value into consideration.
 * One major performance difference was the utilization of the ? operator. Depending on the condition,
 * if the condition is a truthy value, the first value will be returned. Else, the second value is returned.
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ret = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            carry = 0;
            if(sum < 10){
                head.next = new ListNode(sum);
                head = head.next;
            }
            else{
                carry = 1;
                sum = sum - 10;
                head.next = new ListNode(sum);
                head = head.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry == 1){
            head.next = new ListNode(1);
        }
        return ret.next;

    }
}