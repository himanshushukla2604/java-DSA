public class Selection {

    public static int[] selectionSort(int[] arr) {
        for(int i = 0 ;i < arr.length; i++){
            int min = i;
            for(int j= i+1; j< arr.length; j++){
                if(arr[min]< arr[j]){
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 23, 4, 1, 6, 3, 4 };
        arr = selectionSort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
