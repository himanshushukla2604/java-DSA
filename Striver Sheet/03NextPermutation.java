// Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
// Example 1 :
// Input format: Arr[] = {1,3,2}
// Output: Arr[] = {2,1,3}
// Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
// Example 2:
// Input format: Arr[] = {3,2,1}
// Output: Arr[] = {1,2,3}
// Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class NextPermutation {
    public static void permutation(int idx, int[] nums, List<List<Integer>> list){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }

            list.add(ds);
        }

        for(int i = idx; i < nums.length; i++){
            swap(i, idx, nums);
            permutation(idx+1, nums, list);
            swap(i, idx, nums);
        }
        
    }

    public static void swap(int i, int idx, int[] nums){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public static int[] firstApproch(int n, int[] arr){

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0 ;i < n; i++){
            arr[i] = sc.nextInt();
        }

        
    }
}
