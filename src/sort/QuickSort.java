package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String args[]) {
//        int[] arr = {5, 4, 3, 2, 1};
        int[] arr = generateArr(5);
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static int[] generateArr(int size) {

        Random random = new Random();
        int arr[] = new int[size];

        for (int i=0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }

        System.out.println(Arrays.toString(arr));

        return arr;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partitionEnd(arr, begin, end);
            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partitionBegin(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int rightP = end;

        for (int leftP = end; leftP > begin; leftP--) {
            if (arr[leftP] >= pivot) {
                swap(arr, leftP, rightP);
                rightP--;
            }
        }

        swap(arr, begin, rightP);
        return rightP;
    }

    private static int partitionEnd(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int leftP = begin;

        for (int rightP = begin; rightP < end; rightP++) {
            if (arr[rightP] <= pivot) {
                swap(arr, leftP, rightP);
                leftP++;
            }
        }

        swap(arr, leftP, end);
        return leftP;
    }

    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
