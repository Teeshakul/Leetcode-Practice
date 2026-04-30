import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode node = new ListNode(val);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        int pos = sc.nextInt();

        if (pos >= 0) {
            ListNode temp = head;
            ListNode cycleNode = null;
            int index = 0;

            while (temp.next != null) {
                if (index == pos) cycleNode = temp;
                temp = temp.next;
                index++;
            }
            if (cycleNode != null) temp.next = cycleNode;
        }

        Solution obj = new Solution();
        ListNode result = obj.detectCycle(head);

        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("No Cycle");
        }

        sc.close();
    }
}