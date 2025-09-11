import java.util.*;

public class PageAllocation {
    // Function to check if it's possible to allocate books with given constraints
    static boolean isPossible(int[] arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > m || arr[i] > mid) {
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }
    
    // Function to find minimum number of pages
    static int findPages(int[] arr, int n, int m) {
        // If number of students is greater than number of books
        if (m > n) {
            return -1;
        }
        
        int start = 0;
        int sum = 0;
        
        // Calculate sum of all pages
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        int end = sum;
        int ans = -1;
        
        // Binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of books:");
        int n = sc.nextInt();
        
        System.out.println("Enter number of students:");
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter number of pages in each book:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int result = findPages(arr, n, m);
        if (result == -1) {
            System.out.println("Allocation not possible");
        } else {
            System.out.println("Minimum number of pages = " + result);
        }
        
        sc.close();
    }
}
