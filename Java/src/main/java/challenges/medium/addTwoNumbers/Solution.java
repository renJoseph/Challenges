package challenges.medium.addTwoNumbers;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
    // Memory Usage: 38.9 MB, less than 95.33% of Java online submissions for Add Two Numbers.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getResult(l1, l2);
    }

    public ListNode getResult(ListNode l1, ListNode l2) {
        l1.val += l2.val;
        carryDigit(l1);
        if (l1.next == null) {
            if (l2.next != null) {
                l1.next = l2.next;
                getResult(l1.next, new ListNode(0));
            } 
        } else if (l2.next == null) {
            getResult(l1.next,new ListNode(0));
        } else {
            getResult(l1.next, l2.next);
        }
        return l1;
    }

    public void carryDigit(ListNode l1) {
        if (l1.val > 9) {
            int carryDigit = l1.val / 10;
            if (l1.next != null) {
                l1.next.val += carryDigit;
            } else {
                l1.next = new ListNode(carryDigit);
            }
            l1.val = l1.val % 10;
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
