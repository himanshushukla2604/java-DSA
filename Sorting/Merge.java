public class Merge {

    public static void mergea(int[] arr, int mid, int l, int h) {
        int n1 = (mid - l) + 1;
        int n2 = h - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                k++;
                i++;
            } else {

                arr[k] = R[j];
                k++;
                j++;

            }
        }

        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[k] = R[j];
            k++;
            i++;
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = 0;
        if (low < high) {

            mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            mergea(arr, mid, low, high);
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 23, 4, 1, 6, 3, 4 };
        mergeSort(arr, 0, (arr.length - 1));
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
