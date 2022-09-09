public class SubString {

    public static void substr(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }
        // to be
        substr(str, idx + 1, newString + str.charAt(idx));
        // not to be
        substr(str, idx + 1, newString);
    }

    public static void main(String[] args) {
        String str = "abc";
        substr(str, 0, "");

    }
}