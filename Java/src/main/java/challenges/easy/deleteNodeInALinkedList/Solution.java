package challenges.easy.deleteNodeInALinkedList;

public class Solution {

    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/delete-node-in-a-linked-list/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node
    // in a Linked List.
    // Memory Usage: 38.2 MB, less than 78.58% of Java online submissions for Delete
    // Node in a Linked List.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
