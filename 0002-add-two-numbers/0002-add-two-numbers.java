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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode();
        
        ListNode prev = null;
        ListNode node = first;
        boolean up = false;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (up ? 1 : 0);
            up = (sum / 10 == 1);
            
            int val = sum % 10;
            node.val = val;

            prev = node;
            ListNode nextNode = new ListNode();
            node.next = nextNode;
            node = nextNode;

            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (up) {
                node.val = 1;
            } else {
                prev.next = null;
            }
            return first;
        }

        calc(l1, node, up);
        calc(l2, node, up);
        return first;
    }

    public void calc(ListNode list, ListNode node, boolean up) {
        if (node == list) {
            return;
        }

        while(list != null) {
            int sum = list.val + (up ? 1 : 0);
            up = sum == 10;
            node.val = sum % 10;
            
            ListNode nextNode = new ListNode();
            
            if(list.next == null) {
                if (up) {
                    node.next = nextNode;
                    nextNode.val = 1;
                }
                return;
            }

            node.next = nextNode;
            node = nextNode;
            
            list = list.next;
        }
    }
        
}
