import java.util.*;

class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            smallest = Math.min(smallest, prices[i]);
            result = Math.max(result, prices[i] - smallest);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Input prices
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int profit = obj.maxProfit(prices);

        // Output result
        System.out.println("Maximum Profit: " + profit);

        sc.close();
    }
}