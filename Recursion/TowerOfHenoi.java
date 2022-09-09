import java.util.Scanner;

class TowerOfHenoi {
    public static void towerOfHenoi(int n, String source, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer" + n + " from " + source + " to " + dest);
            return;
        }
        // we want to transfer n-1 disks to helper tower user "destination as a helper"
        // | | |
        // [ | ] | |
        // [ | ] | |
        // [ | ] | |
        // [ | ] | |
        // -------------------------------------
        // source helper destination

        // | | |
        // | | |
        // | [ | ] |
        // | [ | ] |
        // [ | ] [ | ] |
        // -------------------------------------
        // source helper destination
        towerOfHenoi(n - 1, source, dest, helper);
        // now source is having one disk only
        // | | |
        // | | |
        // | [ | ] |
        // | [ | ] |
        // [ | ] [ | ] |
        // -------------------------------------
        // source helper destination
        // now we have a to trnser the remain one disk from source to destination
        // | | |
        // | | |
        // | [ | ] |
        // | [ | ] |
        // | [ | ] [ | ]
        // -------------------------------------
        // source helper destination
        System.out.println("Transfer " + n + " form " + source + " to " + dest);
        // now we need to trnsfer (n-1) disks of helper to the destination tower using
        // | | |
        // | | |
        // | [ | ] |
        // | [ | ] |
        // | [ | ] [ | ]
        // -------------------------------------
        // source helper destination

        // | | |
        // | | [ | ]
        // | | [ | ]
        // | | [ | ]
        // | | [ | ]
        // -------------------------------------
        // source helper destination

        // "source as a helper"
        towerOfHenoi(n - 1, helper, source, dest);
    }

    public static void main(String[] args) {
        System.out.println("Enter the Number of disks: ");

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        towerOfHenoi(N, "source", "helper", "dest");

    }
}