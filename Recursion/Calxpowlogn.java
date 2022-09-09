import java.util.Scanner;

public class Calxpowlogn {

    public static int xpowy(int x, int y) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (y == 0) {
            return 1;
        }
        if (y % 2 == 0) {
            return xpowy(x, y / 2) * xpowy(x, y / 2);
        } else {
            return xpowy(x, y / 2) * xpowy(x, y / 2) * x;
        }
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(xpowy(x, y));
    }
}