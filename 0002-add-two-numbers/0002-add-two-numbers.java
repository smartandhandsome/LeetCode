import java.math.BigInteger;
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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sumL1 = new StringBuilder();
        StringBuilder sumL2 = new StringBuilder();
        for (int exp = 0; l1 != null; exp++) {
            sumL1.append(l1.val);
            l1 = l1.next;
        }

        for (int exp = 0; l2 != null; exp++) {
            sumL2.append(l2.val);
            l2 = l2.next;
        }
        sumL1.reverse();
        sumL2.reverse();
        BigInteger sum = new BigInteger(sumL1.toString()).add(new BigInteger(sumL2.toString()));

        ListNode answer = new ListNode(sum.mod(BigInteger.TEN).intValue());
        ListNode prev = answer;
        sum = sum.divide(BigInteger.TEN);
        while (!sum.equals(BigInteger.ZERO)) {
            ListNode listNode = new ListNode(sum.mod(BigInteger.TEN).intValue());
            sum = sum.divide(BigInteger.TEN);
            prev.next = listNode;
            prev = listNode;
        }
        return answer;
    }
}