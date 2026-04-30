import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
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
        System.out.println(obj.hasCycle(head));

        sc.close();
    }
}