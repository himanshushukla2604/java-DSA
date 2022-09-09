public class Bubble {

    public static int[] bubbleSort(int[] arr) {
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < (arr.length - 1) - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return arr;// if array is already sorted
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 23, 12, 90, 1, 6, 9 };

        arr = bubbleSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}