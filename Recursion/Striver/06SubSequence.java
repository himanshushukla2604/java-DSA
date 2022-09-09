import java.util.ArrayList;
// import java.util.List;

class Subsequences {
    public static void printSubsequence(int idx, int[] arr, ArrayList<Integer> r) {
        if (idx >= arr.length) {
            System.out.println(r.toString());
            return;
        }

        r.add(arr[idx]);
        printSubsequence(idx + 1, arr, r);
        r.remove(r.lastIndexOf(arr[idx]));
        printSubsequence(idx + 1, arr, r);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        printSubsequence(0, arr, new ArrayList<Integer>());

    }

}
