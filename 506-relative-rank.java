import java.util.*;

class Pair {
    int ele;
    int ind;

    public Pair(int ele, int ind) {
        this.ele = ele;
        this.ind = ind;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.ele, a.ele));

        for (int i = 0; i < score.length; i++) {
            pq.add(new Pair(score[i], i));
        }

        String[] ans = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            Pair p = pq.poll();

            if (i == 0) ans[p.ind] = "Gold Medal";
            else if (i == 1) ans[p.ind] = "Silver Medal";
            else if (i == 2) ans[p.ind] = "Bronze Medal";
            else ans[p.ind] = String.valueOf(i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        String[] result = obj.findRelativeRanks(score);

        for (String s : result) {
            System.out.print(s + " ");
        }

        sc.close();
    }
}