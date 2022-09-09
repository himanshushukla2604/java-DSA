public class RemoveDublicate {
    static boolean[] arr = new boolean[26];

    public static void rmvDublicate(String str, int i, String newstr) {
        if (i == str.length()) {
            System.out.println(newstr);
            return;
        }
        if (arr[str.charAt(i) - 'a']) {
            rmvDublicate(str, ++i, newstr);
        } else {
            newstr += str.charAt(i);
            arr[str.charAt(i) - 'a'] = true;
            rmvDublicate(str, ++i, newstr);
        }
    }

    public static void main(String[] args) {
        String str = "abcacb";

        rmvDublicate(str, 0, "");

    }
}
