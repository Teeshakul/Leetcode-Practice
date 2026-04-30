import java.util.*;

class BrowserHistory {

    List<String> history;
    int index;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        index = 0;
    }

    public void visit(String url) {
        while (history.size() > index + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        index++;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return history.get(index);
    }

    public String forward(int steps) {
        index = Math.min(history.size() - 1, index + steps);
        return history.get(index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String homepage = sc.next();
        BrowserHistory bh = new BrowserHistory(homepage);

        int q = sc.nextInt();

        while (q-- > 0) {
            String op = sc.next();

            if (op.equals("visit")) {
                String url = sc.next();
                bh.visit(url);
            } 
            else if (op.equals("back")) {
                int steps = sc.nextInt();
                System.out.println(bh.back(steps));
            } 
            else if (op.equals("forward")) {
                int steps = sc.nextInt();
                System.out.println(bh.forward(steps));
            }
        }

        sc.close();
    }
}