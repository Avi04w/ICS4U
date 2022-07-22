package Sorting;

import java.util.Random;

public class Selection {
    public static void main(String[] args){
        Random random = new Random();

        int[] comparisons = new int[20];

        for (int i = 0; i < 20; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(20) + 1;
            }


            arr = new int[]{9, 20, 7, 18, 8, 40, 35, 6, 2, 11, 13};

            System.out.print("Array : ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println("\n");

            comparisons[i] = SelectionSort(arr);

            System.out.println("Comparisons: " + comparisons[i]);
        }

        System.out.print("\n\nComparisons made: ");
        for (int num : comparisons) {
            System.out.print(num + " ");
        }
        int sum = 0;
        for (int num : comparisons){
            sum += num;
        }
        float average = (float) sum/20;

        System.out.print("\nTotal comparisons made: " + sum);
        System.out.printf("\nAverage comparisons: %.0f", average);
    }

    public static int SelectionSort(int[] arr){
        int comparisons = 0;
        int numSorted = 0;
        for (int i = 0; i < arr.length - 1; i++){
            int maxIndex = 0;
            int max = arr[0];
            for (int j = 1; j < (arr.length - numSorted); j++){
                if (arr[j] >= arr[maxIndex]){
                    maxIndex = j;
                    max = arr[j];
                }
                comparisons ++;
            }

            System.out.println("Largest Number: " + max);

            if (maxIndex != arr.length - numSorted - 1){
                int temp = arr[arr.length - numSorted - 1];
                arr[arr.length - numSorted - 1] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
            numSorted++;

            for (int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("Sorted Array: ");
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

        return comparisons;
    }
}