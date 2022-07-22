package DataStructures.LinkedList;

import java.util.LinkedList;

public class LinkedListEmployee {
    //instance variables
    private Node head;

    //constructor
    public LinkedListEmployee(){
        head = null;
    }

    //methods

    /**
     * This method takes in an Employee object and sets it as the first item in the list. It first creates a new
     * node, connects it to the current head and then changes the head to the new node.
     * @param e - Employee object
     */
    public void addToFront(Employee e){
        Node newNode = new Node(e);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * This method takes in a String which tells it which employee to remove from the list. It searches through
     * the list looking for the employee and connects the node before it to the node after it, cutting it
     * out of the list.
     * @param s - String of employee name
     */
    public void remove(String s){
        Node prev = head;
        Node curr = head;
        while(!curr.getData().getName().toLowerCase().equals(s)){
            prev = curr;
            curr = curr.getNext();
        }
        prev.setNext(curr.getNext());
    }

    /**
     * This method will remove the first node in the list by setting the second node as the head.
     * There are no parameters or return values.
     */
    public void removeHead(){
        head = head.next;
    }

    /**
     * This method takes in a String of an employee name and returns the index of that employee in the list.
     * @param name - String of employee name
     * @return an integer which represents the index of the entered value
     */
    public int indexOf(String name){
        Node curr = head;
        int index = 0;
        while(!curr.getData().getName().toLowerCase().equals(name)) {
            curr = curr.getNext();
            index++;
        }
        return index;
    }

    /**
     * This method searches through the list and returns the youngest employee. There are no parameters.
     * @return an Employee object
     */
    public Employee youngest(){
        Node curr = head;
        Employee yEmp = curr.getData();
        while(curr.next != null){
            curr = curr.getNext();
            if (curr.getData().getDateOfBirth() > yEmp.getDateOfBirth()){
                yEmp = curr.getData();
            }
        }
        return yEmp;
    }

    /**
     * This method returns the size of the current list. There are no parameters.
     * @return an integer which represents the size of the list
     */
    public int size(){
        Node curr = head;
        int i = 1;
        while (!(curr.next == null)){
            curr = curr.next;
            i++;
        }
        return i;
    }

    public Employee get(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.getData();
    }

    /**
     * This method returns the Employee that is in the head Node of the list.
     * @return Employee object
     */
    public Employee head(){
        return head.getData();
    }

    /**
     * This method returns a String of the information of all the Employee objects in the list.
     * There are no parameters.
     * @return String of list information.
     */
    public String toString(){
        Node current = head;
        String info = "";
        while (current != null){
            info += current.getData() + "\n";
            current = current.getNext();
        }
        return info;
    }

    //----------------------------------------------------------------------------------------------------------------
    //Node class
    private class Node{
        //Instance variables
        private Employee data;
        private Node next;

        //Constructor
        public Node(Employee e){
            data = e;
            next = null;
        }

        //Methods

        /**
         * This method will return the next Node
         * No parameters
         * @return Node
         */
        public Node getNext() {
            return next;
        }

        /**
         * This method sets next value of a node
         * @param newNode the Node which needs to be set as next.
         * Does not return anything
         */
        public void setNext(Node newNode) {
            next = newNode;
        }

        /**
         * This method returns the value of the data variable
         * No parameters
         * @return an Employee object which is stored in the variable - 'data'.
         */
        public Employee getData() {
            return data;
        }
    }
}
