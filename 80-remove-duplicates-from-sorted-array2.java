import java.util.*;

class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int n : nums) {
            if (k < 2 || nums[k - 2] != n) {
                nums[k++] = n;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array (should be sorted)
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int k = obj.removeDuplicates(nums);

        // Output result
        System.out.println("New length: " + k);
        System.out.print("Array after removing extra duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}