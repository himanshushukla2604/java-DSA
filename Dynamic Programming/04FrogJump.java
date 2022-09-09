import java.util.Scanner;
import java.util.Arrays;

class FrogJump {
    public static int frogEnergy(int[] heights, int idx) {
        if (idx == 0)
            return 0;

        int left = frogEnergy(heights, idx - 1) + Math.abs(heights[idx] - heights[idx - 1]);

        if (idx > 1) {

            int right = frogEnergy(heights, idx - 2) + Math.abs(heights[idx] - heights[idx - 2]);
            return Math.min(left, right);
        } else {
            return left;
        }
    }

    // --------------------memoization---------------------------------

    public static int jumpfrog(int n, int[] heights, int[] dp) {
        if (n == 0)
            dp[n] = 0;
        if (dp[n] != -1)
            return dp[n];
        int left = jumpfrog(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = jumpfrog(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);

        return dp[n] = Math.min(right, left);
    }

    // --------------------Tabulation----------------------------------
    public static int JumpFrogTabulation(int[] heights, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1)
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(fs, ss);
        }
        return dp[n - 1];
    }

    // ---------------Tabulation SpaceComplexity -----------------------
    public static int JumpFrogTabulationS(int[] heights, int n) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev + (Math.abs(heights[i] - heights[i - 1]));
            int ss = Integer.MAX_VALUE;
            if (i > 1)
                ss = prev2 + (Math.abs(heights[i] - heights[i - 2]));

            int curr = Math.min(fs, ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    // ---------------Kjums of forgs---------------------------------------
    public static int KJumpFrogs(int[] heights, int k, int idx) {
        if (idx == 0 || (idx - k) < 0)
            return 0;
        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            int jump = KJumpFrogs(heights, k, idx - j) + Math.abs(heights[idx] - heights[idx - j]);
            min = Math.min(min, jump);

        }
        return min;

    }

    // Tabulation

    public static int KJumpFrogsTabulation(int[] heights, int k, int n) {
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if ((i - j) >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int[] heights = new int[stairs];

        for (int i = 0; i < stairs; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println("Recursion : " + frogEnergy(heights, stairs - 1));
        int[] dp = new int[stairs];
        Arrays.fill(dp, -1);
        System.out.println("Memoization : " + jumpfrog(stairs - 1, heights, dp));

        // Tabulation
        System.out.println("Tabulation : " + JumpFrogTabulation(heights, stairs));

        // Tabulation with Space Complexity
        System.out.println("Tabultion with Optimised Space : " + JumpFrogTabulationS(heights, stairs));

        // frog jump k steps
        System.out.println("K steps: " + KJumpFrogs(heights, 2, stairs - 1));
        // }
        System.out.println("K steps: " + KJumpFrogsTabulation(heights, 3, stairs - 1));
    }
}
