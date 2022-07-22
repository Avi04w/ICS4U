package Sorting;

import java.util.Random;

public class Insertion {
    public static void main(String[] args){
        Random random = new Random();

        int[] comparisonsArray = new int[20];

        for (int i = 0; i < 20; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(20) + 1;
            }

            System.out.print("Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();

            int comparisons = InsertionSort(arr);
            comparisonsArray[i] = comparisons;

            System.out.print("\nComparisons made: " + comparisons);
            System.out.println("\n");
        }

        int sum = 0;
        for (int num : comparisonsArray){
            sum += num;
        }
        float average = (float) sum/20;

        System.out.print("\nTotal comparisons made: " + sum);
        System.out.printf("\nAverage comparisons: %.0f", average);
    }

    public static int InsertionSort(int[] arr){
        int comparisons = 0;
        int[] sorted = new int[arr.length];
        int numSorted = 0;

        for (int num : arr){
            if (numSorted == 0){
                sorted[0] = num;
                numSorted ++;
                comparisons++;
            } else if (numSorted == 1){
                if (sorted[0] >= num){
                    sorted[1] = sorted[0];
                    sorted[0] = num;
                } else {
                    sorted[1] = num;
                }
                numSorted ++;
                comparisons++;
            } else {
                if(num <= sorted[0]){
                    System.arraycopy(sorted, 0, sorted, 1, sorted.length - 1);
                    sorted[0] = num;
                    numSorted ++;
                    comparisons++;
                } else if (num >= sorted[numSorted-1]) {
                    sorted[numSorted] = num;
                    numSorted ++;
                    comparisons++;
                } else {
                    for (int i = 0; i < (numSorted - 1); i++) {
                        comparisons++;
                        if (num >= sorted[i] && num <= sorted[i + 1]) {
                            System.arraycopy(sorted, i, sorted, i + 1, sorted.length - 1 - i);
                            sorted[i+1] = num;
                            numSorted++;
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < numSorted; i++){
                System.out.print(sorted[i] + " ");
            }
            System.out.println();
        }

        System.out.print("\nSorted Array: ");
        for (int num : sorted){
            System.out.print(num + " ");
        }
        return comparisons;
    }
}