package Arrays2D;

import java.util.Scanner;

public class ExpenseList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float[][] expenses = new float[12][3];
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        String[] headers = {"Jojo's", "Cell Phone", "Car Insurance", "Food", "\nExpenses"};


        float totalCell = 0;
        float totalCar = 0;
        float totalFood = 0;

        for (int i = 0; i < expenses.length; i++){

            System.out.println(months[i] + " Expenses");

            System.out.print("Cell Phone Expense: ");
            expenses[i][0] = input.nextFloat();
            totalCell += expenses[i][0];
            System.out.print("Car Insurance Expense: ");
            expenses[i][1] = input.nextFloat();
            totalCar += expenses[i][1];
            System.out.print("Food Expense: ");
            expenses[i][2] = input.nextFloat();
            totalFood += expenses[i][2];
        }

        for(String header : headers){
            System.out.print(header + "     ");
        }

        System.out.println();

        for (int i = 0; i < expenses.length; i++) {
            System.out.print(months[i] + "        ");
            for (int j = 0; j < expenses[i].length; j++) {
                System.out.print("$" + expenses[i][j]);
                for (int k = 0; k < (11 - (int)(Math.log10(expenses[i][j])) + 1); k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.printf("Totals:    " + "$%.2f" + "        $%.2f" + "        $%.2f", totalCell, totalCar, totalFood);

        System.out.println();

        System.out.println("Total Expenses: $" + (totalCell + totalCar + totalFood));

        input.nextLine();

        System.out.print("Update any Entry? ");
        String run = input.nextLine().toLowerCase();

        if (run.equals("yes")){
            System.out.print("Enter which month: ");
            String month = input.nextLine().toLowerCase();
            System.out.print("Enter which bill: ");
            String bill = input.nextLine();
            System.out.print("Enter new value: ");
            float newValue = input.nextFloat();

            int monthIndex = 0;
            int headerIndex = 0;

            for (int i = 0; i < months.length; i++){
                if (months[i].equals(month)) {
                    monthIndex = i;
                }
            }

            for (int i = 0; i < headers.length; i++){
                if (headers[i].equals(bill)) {
                    headerIndex = i;
                }
            }

            expenses[monthIndex][(headerIndex - 1)] = newValue;

        } else {
            System.out.println("Have a good day!");
        }

    }
}