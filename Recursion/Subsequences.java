public class Subsequences {

    public static void subseq(String str, String newstr, int idx) {
        if (idx == str.length()) {
            System.out.println(newstr);
            return;
        }
        char currChar = str.charAt(idx);

        // to be
        subseq(str, newstr + currChar, idx + 1);

        // or not to be
        subseq(str, newstr, idx + 1);
    }
// time complexity 2^n
    public static void main(String[] args) {
        String str = "Himanshu";
        subseq(str, "", 0);
    }
}
