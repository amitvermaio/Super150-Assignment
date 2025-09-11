import java.util.*;

public class CombinationsSum {
    static void helper(int[] res, int[] arr, int n, int idx, int target) {
        if (idx == n) {
            if (target == 0) {
                res[0]++;
            }
            return;
        }

        helper(res, arr, n, idx+1, target-arr[idx]);
        helper(res, arr, n, idx+1, target);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3};
        int[] res = new int[1];
        helper(res, arr, arr.length, 0, 3);
        System.out.println(res[0]);
        sc.close();
    }
}
