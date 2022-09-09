import java.util.List;
import java.util.ArrayList;

public class PalindromePartetioning {
    public static List<List<String>> partetioning(String str) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(res, path, 0, str);
        return res;
    }

    public static void helper(List<List<String>> res, List<String> path, int idx, String str) {
        if (idx == str.length()) {
            res.add(path);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            if (isPalindrome(str.substring(idx, i + 1), idx, i)) {
                path.add(str.substring(idx, i + 1));
                helper(res, path, i + 1, str);
                path.remove(path.size() - 1);
            }
        }

    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partetioning("aab");
    }
}
