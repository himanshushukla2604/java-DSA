import java.util.Scanner;

public class ReverseString {
    public static void RevStr(String str, int n) {
        System.out.print(str.charAt(n));
        if (n > 0)
            RevStr(str, n - 1);
    }

    public static void main(String[] args) {

        String str = new Scanner(System.in).nextLine();
        RevStr(str, str.length() - 1);
    }
}