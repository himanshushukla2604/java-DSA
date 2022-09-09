import java.util.Scanner;

public class FirstLastOccurance {
    public static int first = -1;
    public static int last = -1;

    public static void findFirstLast(String str, char word, int idx) {
        if (word == str.charAt(idx)) {
            if (first == -1) {
                first = idx;
                last = idx;
            } else {
                last = idx;
            }
        }
        if (idx == str.length() - 1) {
            return;
        }
        findFirstLast(str, word, ++idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        findFirstLast(str, 'a', 0);
        System.out.println(first + " " + last);
    }
}