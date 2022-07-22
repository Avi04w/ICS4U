/* Avi Walia
 * Ms. Katsman
 * May 10
 * ICS4U
 *
 * This code creates a linked list of employees in a company. The code allows the user to enter the employee at the
 * lowest level in the company and then enter their supervisors. When they are done, they simply need to type
 * in 'exit'. After this, the employees are then listed to them from the highest position to the lowest position.
 * It then allows the user to enter a name of an employee and displays to them how many supervisors are between that
 * employee and the owner. It then displays the youngest employee. My unique feature that I added was that you can
 * fire an employee. Let's say the employee at the second level from the top was fired, they would be removed from the
 * list and the direct superior of the employee at the third level from the top would now be the owner.
 */

package DataStructures.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Creating empty linked list
        LinkedListEmployee list = new LinkedListEmployee();

        //Getting employee at lowest level
        //Ask for name, date of birth, and job title
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter Date of Birth (yyyymmdd): ");
        int birthday = input.nextInt();
        input.nextLine();
        System.out.print("Enter Title: ");
        String title = input.nextLine();
        //Adding Employee object to front of list
        list.addToFront(new Employee(name, birthday, title));

        //flag for while loop
        boolean flag = true;
        while(flag){
            System.out.println("Type 'exit' if owner has been entered. Type Anything else to continue.");
            String a = input.nextLine().toLowerCase();
            //If user enters 'exit' loop will finish and no more employees will be added
            if (a.equals("exit")){
                flag = false;
            } else {
                //If they enter anything else, new Employee object is added to front of list
                //This new employee will now be the highest level employee
                list.addToFront(setEmployee());
            }
        }

        //Displaying employee list from the highest level to lowest
        System.out.println("Employee List:");
        System.out.println(list);

        //Checking how far an employee is from the owner
        System.out.println("Finding how many supervisors are between an employee and the owner");
        System.out.print("Enter Employee Name: ");
        //Find index of inputted employee in the list
        int index = list.indexOf(input.nextLine().toLowerCase());

        //If the index is 0, then the entered employee is the owner
        if (index == 0){
            System.out.println("This employee is the owner!");
        } else { //Else, there are index-1 number of supervisors between inputted employee and owner
            System.out.printf("There are %d supervisors between this employee and the owner.\n", index - 1);
        }

        //Printing youngest employee using the youngest() method
        System.out.println("\nThe youngest employee is: " + list.youngest().getName() +
                " and they were born on: " + list.youngest().getDateOfBirth());

        //Unique Feature - Firing an employee
        //Asking user if they would like to fire anyone?
        System.out.print("\nWould you like to fire an employee? (y/n) ");
        String s = input.nextLine().toLowerCase();
        if (s.equals("y")){
            //If yes, then first check size of list
            if (list.size() == 1){
                //If there is only 1 employee, confirm with the user if they would like to fire them.
                System.out.println("There is only 1 Employee. Are you sure that you want to remove them? (y/n) ");
                String yesNo = input.nextLine().toLowerCase();
                if (yesNo.equals("y")){
                    //If they say yes, then reset list to be empty
                    list = new LinkedListEmployee();
                } else {
                    //If they say no, then nothing will happen
                    System.out.println("They will not be removed!");
                }
            } else {
                //If there is more than 1 employee
                //Ask who to fire
                System.out.print("Who would you like to fire? (Enter Full Name) ");
                String rName = input.nextLine().toLowerCase();
                //If the name entered is the owner, confirm with user if this is what they want to do
                if (rName.equals(list.head().getName().toLowerCase())){
                    System.out.println("You are firing the owner.");
                    System.out.print("Are you sure that you want to do this? (y/n) ");
                    String yn = input.nextLine().toLowerCase();
                    if (yn.equals("y")){
                        //If they say yes
                        //Remove owner using removeHead method
                        list.removeHead();
                    } else {
                        //If they say no, then remove no one.
                        System.out.println("Owner will not be removed.");
                    }
                } else {
                    //If the name entered is a regular employee, fire them without confirmation
                    list.remove(rName);
                }
                //Print out updated employee list
                System.out.println("Employee List:");
                System.out.print(list);
            }
        } else {
            //If they say no, no one will be fired
            System.out.println("No one will be fired!");
        }
    }

    /**
     * This method creates a new Employee object by asking the user what to set the parameters as.
     * There are no parameters to be inputted
     * @return Employee object which was created with an overloaded constructor
     */
    public static Employee setEmployee(){
        Scanner input = new Scanner(System.in);
        //Ask for name
        System.out.print("Enter Name of supervisor: ");
        String name = input.nextLine();
        //Ask for date of birth
        System.out.print("Enter Date of Birth (yyyymmdd): ");
        int birthday = input.nextInt();
        input.nextLine();
        //Asker for Title
        System.out.print("Enter Title: ");
        String title = input.nextLine();

        //Return new Employee object
        return new Employee(name, birthday, title);
    }
}
