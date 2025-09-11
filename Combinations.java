import java.util.*;

public class Combinations {
    static void helper(List<List<Integer>> res, int n, int k, List<Integer> curr, int idx) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=idx; i<=n; i++) {
            curr.add(i);
            helper(res, n, k, curr, idx+1);
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res, n, k, curr, 1);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Combinations comb =  new Combinations();
        System.out.print("Enter Range end number: ");
        int n = sc.nextInt();
        System.out.print("Enter size of List: ");
        int k = sc.nextInt();
        List<List<Integer>> res = comb.combine(n, k);
        System.out.println("List will be: "+res);
        sc.close();
    }
}