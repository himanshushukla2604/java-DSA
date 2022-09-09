public class MergeSort {

    public void merge(int[] arr, int l, int mid, int h) {

    }

    public int[] mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    public static void main(String[] args) {

    }
}
