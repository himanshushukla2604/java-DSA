import java.util.Scanner;

public class Removedublicates {
    public static boolean[] alphamap = new boolean[26];

    public static void removeDublicates(String str, String newStr, int idx) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (alphamap[currChar - 'a'] == true) {
            removeDublicates(str, newStr, idx + 1);
        } else {
            newStr += currChar;
            alphamap[currChar - 'a'] = true;
            removeDublicates(str, newStr, idx + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        removeDublicates(str, "", 0);
    }
}
