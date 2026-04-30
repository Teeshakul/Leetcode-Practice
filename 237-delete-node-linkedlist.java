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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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

        ListNode node = head;
        for (int i = 0; i < pos; i++) {
            node = node.next;
        }

        Solution obj = new Solution();
        obj.deleteNode(node);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}
