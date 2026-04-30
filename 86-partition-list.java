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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode res = less;

        ListNode great = new ListNode(-1);
        ListNode res2 = great;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
                head = head.next;
                less.next = null;
            } else {
                great.next = head;
                great = head;
                head = head.next;
                great.next = null;
            }
        }

        less.next = res2.next;
        return res.next;
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

        int x = sc.nextInt();

        Solution obj = new Solution();
        head = obj.partition(head, x);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}