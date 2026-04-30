import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode list1 = head;
        ListNode list2;
        ListNode s = head;
        ListNode f = head;

        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }

        list2 = s.next;
        s.next = null;

        ListNode cur = list2;
        ListNode prev = null;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        list2 = prev;

        ListNode n;
        ListNode p;

        while (list2 != null) {
            n = list1.next;
            p = list2.next;

            list1.next = list2;
            list2.next = n;

            list2 = p;
            list1 = list1.next.next;
        }
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

        Solution obj = new Solution();
        obj.reorderList(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}