package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]) {
        int[] arr = {7, 6, 3, 2, 4, 1, 1, 2};
        mergeSort(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (end - begin > 1) {
            int middle = (begin + end) / 2;
            mergeSort(arr, begin, middle);
            mergeSort(arr, middle, end);

            merge(arr, begin, middle, end);
        }
    }

    private static void merge(int[] arr, int begin, int middle, int end) {
        int[] leftArr = Arrays.copyOfRange(arr, begin, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, end);
        int curLeft = 0;
        int curRight = 0;

        for (int i = begin; i < end; i++) {
            if (curLeft >= leftArr.length) {
                arr[i] = rightArr[curRight];
                curRight++;
            } else if (curRight >= rightArr.length) {
                arr[i] = leftArr[curLeft];
                curLeft++;
            } else if (leftArr[curLeft] < rightArr[curRight]) {
                arr[i] = leftArr[curLeft];
                curLeft++;
            } else if (leftArr[curLeft] >= rightArr[curRight]) {
                arr[i] = rightArr[curRight];
                curRight++;
            }
        }
    }
}
