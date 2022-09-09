import java.util.Scanner;

class Fibonachi {

    // Time Complexity = O(n)
    // Space Complexity = O(n)// here we do not require extra stack space
    public static int fibo(int n) {
        int[] dp = new int[n + 1];

        // in tabulation we follow bottom up approch
        // we will first solve base cases which are 0&1
        dp[0] = 0;
        dp[1] = 1;
        // new for other sub problems we will start looping through
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // -------------------------------------------------------------------------------
    // we can go for even more optimized solution
    // Time Complexity = O(n)
    // Space Complexity = O(1)

    public static int fiboSO1(int n) {
        int prev2 = 0;// for 0
        int prev = 1; // for 1
        int curr;
        for (int i = 2; i <= n; i++) {
            // i = i-1 + i-2
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Simple Tabulation : " + fibo(n));
        System.out.println("Optimized Tabulation : " + fiboSO1(n));
    }
}
