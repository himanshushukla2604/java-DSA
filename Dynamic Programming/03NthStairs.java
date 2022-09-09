// You have been given a number of stairs. Initially, you are at the 0th stair,
// and you need to reach the Nth stair. Each time you can either climb one step
// or two steps. You are supposed to return the number of distinct ways in which
// you can climb from the 0th step to Nth step.
// https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650

class NthStairs {
    // static int count = 0;

    public static int nthStairs(int stairs, int idx) {

        if (idx > stairs)
            return 0;

        if (idx == stairs)
            return 1;

        return nthStairs(stairs, idx + 1) + nthStairs(stairs, idx + 2);
    }

    // Tabulation
    // this problum is a lot more similer to fibonachi seriess
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 0)
            return 0;
        dp[0] = 1;// if the person is as 0, the task is completed we got a way to reach there
        dp[1] = 1;// if the person is at 1 it means he have only one way to reach there
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        // dp[2] = dp[1] + dp[0] here if person is at 2 he have 2 ways to reach 0 either
        // by one step or by 2 step.

        // dp[3] = dp[2] + dp[1] here if person is at 3 he have 3 ways to reach 0( 1.
        // take 2steps and then one, 2. take one step and then two, 3. every time take
        // single step)

        // and so on ..........

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthStairs(3, 0));

        System.out.println("Tabulation : " + climbStairs(3));
    }
}
