import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Stack<Node> st = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    st.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }

            if (curr.next == null && !st.isEmpty()) {
                curr.next = st.pop();
                curr.next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, prev = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node node = new Node(val);

            if (head == null) {
                head = node;
            } else {
                prev.next = node;
                node.prev = prev;
            }
            prev = node;
        }

        Solution obj = new Solution();
        Node result = obj.flatten(head);

        Node temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}