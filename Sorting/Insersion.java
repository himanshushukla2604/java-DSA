public class Insersion {

    public static int[] insersionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentelement = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > currentelement) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentelement;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 23, 21, 8, 4 };
        arr = insersionSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
