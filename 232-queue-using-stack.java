import java.util.*;

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();

        int n = sc.nextInt();

        while (n-- > 0) {
            String op = sc.next();

            if (op.equals("push")) {
                int x = sc.nextInt();
                q.push(x);
            } 
            else if (op.equals("pop")) {
                System.out.println(q.pop());
            } 
            else if (op.equals("peek")) {
                System.out.println(q.peek());
            } 
            else if (op.equals("empty")) {
                System.out.println(q.empty());
            }
        }

        sc.close();
    }
}