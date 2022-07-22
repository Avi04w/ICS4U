package Sorting;

public class Binary {
    public static void main (String[] args){
        int[] arr = {3, 8, 9, 10, 12, 15, 32, 35, 36, 48};
        int num = 8;

        System.out.println(binarySearch(arr, num));
    }

    static int binarySearch (int[] numArray, int num){
        int comparisons = 0;
        int low = 0;
        int high = numArray.length-1;
        while (low <= high){
            comparisons ++;
            int mid = (low + high) / 2;
            if (num < numArray[mid]){
                high = mid - 1;
            } else if (num > numArray[mid]){
                low = mid + 1;
            } else if (num == numArray[mid]){
                System.out.println("Comparisons: " + comparisons);
                return mid;
            }
        }
        return -1;
    }
}