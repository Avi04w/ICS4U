package DataStructures.LinkedList;

//Employee Class
public class Employee {
    //Instance variables
    private String name, title;
    private int dateOfBirth;

    //Constructor
    public Employee(){
        name = "";
        dateOfBirth = 0;
        title = "";
    }

    //Overloaded constructor
    public Employee(String name, int dateOfBirth, String title){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.title = title;
    }

    //Method
    /**
     * This method takes no parameters and returns the name of the employee
     * @return String of Employee name
     */
    public String getName() {
        return name;
    }

    /**
     * This method takes no parameters and returns the date of birth of the employee
     * @return int of the employee's date of birth
     */
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * This method takes no parameters and returns the job title of the employee
     * @return String of Employee title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method returns a String which contains the information of the Employee object. This includes
     * name, date of birth, and title
     * @return String of Employee information
     */
    public String toString(){
        return "Name: " + name + ", Date of Birth: " + dateOfBirth + ", Title: " + title;
    }
}
