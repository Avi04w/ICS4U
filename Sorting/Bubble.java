package Sorting;

public class Bubble {
    public static void BubbleSort(int[] arr){
        int correct = 0;
        while (correct != arr.length){
            for (int i = (arr.length - 1); i > correct; i--){
                int first = arr[i];
                int second = arr[i-1];
                if (first > second){
                    arr[i] = second;
                    arr[i-1] = first;
                }
            }
            correct ++;
        }
    }
}