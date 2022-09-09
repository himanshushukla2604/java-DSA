// import java.util.Scanner;

public class SortedStrictlyIncreasing {
    public static boolean checkSorting(int[] arr, int i) {
        if (i == arr.length) {
            return true;
        }
        if (arr[i - 1] >= arr[i]) {
            return false;
        }
        return SortedStrictlyIncreasing.checkSorting(arr, i + 1);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4, 5 };
        if (SortedStrictlyIncreasing.checkSorting(arr, 1))
            System.out.println("This array is Strictly Incresing");
        else
            System.out.println("This array is not Strictly Incresing");
    }
}
