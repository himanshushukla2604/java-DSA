public class Quick {

    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int l = low;
        int r = high;
        int p = arr[low];

        while (l < r) {
            while (arr[l] <= p && l < r) {
                l++;
            }

            while (arr[r] > p) {
                r--;
            }

            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        // now we are assing the value of arr[r] to pivert
        arr[low] = arr[r];
        // now we are assing the value of pivert fo arr[r]
        arr[r] = p;

        quickSort(arr, low, r - 1);
        quickSort(arr, r + 1, high);

    }

    public static void main(String[] args) {
        int[] arr = { 23, 4, 1, 6, 3, 4 };
        quickSort(arr, 0, (arr.length - 1));
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
