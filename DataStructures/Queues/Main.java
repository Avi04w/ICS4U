/* Avi Walia
 * Ms. Katsman
 * May 10
 * ICS4U
 *
 * This code creates a queue of 10 people, and allows the user to enter 10 names to fill it up.
 * After this, it will then dequeue names from the queue until a name starting with is found. If no names are starting
 * with 'M', then the queue will be emptied. Otherwise, the remaining queue will be printed. The number of spaces after
 * each enqueue and dequeue will be displayed to the user.
 */

package DataStructures.Queues;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Creating queue
        Queue names = new Queue(10);

        int index = 1;

        //Ask for name
        System.out.print("Enter Name " + index + ": ");
        //Add name to back of queue
        names.enqueue(input.nextLine());
        int spaces = 10 - names.size();
        //Telling user how many spaces are left
        System.out.println(spaces + " spaces left.");
        index++;

        //Asking user for names to put in queue
        boolean running = true;
        while(index <= 10 && running) {
            //If user enters stop, stop asking for names
            System.out.print("Enter 'stop' to stop entering names or anything else to continue: ");
            String s = input.nextLine().toLowerCase();
            if (s.equals("stop")){
                running = false;
            } else {
                //Ask for name
                System.out.print("Enter Name " + index + ": ");
                //Add name to back of queue
                names.enqueue(input.nextLine());
                spaces = 10 - names.size();
                //Telling user how many spaces are left
                System.out.println(spaces + " spaces left.");
                index++;
            }
        }
        //Additional Feature - once the queue is full, let the user know that they can no longer add new names
        if (names.size() == 10){
            System.out.println("Queue is full! You cannot add any more names");
        }

        System.out.println("\n");

        boolean dequeue = true; //Flag for while loop
        while(names.size() > 0 && dequeue){
            //Check if name at front of queue starts with 'M'
            if (names.front().toLowerCase().charAt(0) != 'm'){
                //If it doesn't, dequeue it
                String str = names.dequeue();
                System.out.println("De-queueing " + str);
                //Tell user how many names left in queue
                System.out.println(names.size() + " names in queue.");
                System.out.println();
            } else {
                //If name does start with 'M', stop removing names and tell user
                System.out.println("Name starting with 'M' has been found! " + names.front());
                dequeue = false; //Stop loop
            }
        }

        if (names.isEmpty()){ //If there are no names that start with 'M'
            System.out.println("There are no names starting with the letter 'm'.");
        } else { //Print out remaining names left in queue
            System.out.println("Remaining queue: " + names);

            //Unique Feature
            //Displays first letter of all the remaining names and empties queue at the end of the program
            System.out.print("\nThe remaining names start with: ");
            int n = names.size();
            for (int i = 0; i < n; i++){
                String name = names.dequeue(); //Dequeueing first name in queue and saving the name to String name
                System.out.print(name.charAt(0) + "  "); //Printing first letter of name
            }
        }
    }
}
