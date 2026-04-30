import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        Stack<Integer> st = new Stack<>();

        int n = nums2.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], st.peek());

            st.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int[] result = obj.nextGreaterElement(nums1, nums2);

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}