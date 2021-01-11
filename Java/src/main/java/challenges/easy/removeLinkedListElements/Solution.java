package challenges.easy.removeLinkedListElements;

class Solution {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/remove-linked-list-elements/
    // Runtime: 1 ms, faster than 74.38% of Java online submissions for Remove
    // Linked List Elements.
    // Memory Usage: 40.1 MB, less than 39.90% of Java online submissions for Remove
    // Linked List Elements.
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
