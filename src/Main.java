import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,9,0,37,6,20};
       quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int left,int right) {
        if (left >= right) return;
        int pivot = quick(arr,left,right);
        quickSort(arr,left,pivot - 1);
        quickSort(arr,pivot + 1,right);
    }

    private static int quick(int[] arr, int left, int right) {
        // 挖坑法
        int pivot = arr[left];
        while (left < right) {
            // 从右往左找小
            while ((left < right) && (arr[right] >= pivot)) {
                right--;
            }
            arr[left] = arr[right];
            // 从左到右找打
            while ((left < right) && (arr[left] <= pivot)) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
