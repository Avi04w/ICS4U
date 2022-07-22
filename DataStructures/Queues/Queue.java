package DataStructures.Queues;

public class Queue {
    //Instance Variables
    private int front;
    private int end;
    private final int maxSize;
    private String[] data;

    //Constructor (Has max size of 5)
    public Queue(){
        front = 0;
        end = 0;
        data = new String[5];
        maxSize = data.length;
    }

    //Overloaded Constructor (Can set max size)
    public Queue(int n){
        front = 0;
        end = 0;
        data = new String[n];
        maxSize = n;
    }

    /**
     * This method checks if the queue is empty by checking if the front and end of the queue are set to 0
     * which is the beginning of the queue
     * No parameters
     * @return a boolean which indicates whether the list is empty or not (true for yes and false for no)
     */
    public boolean isEmpty(){
        return front == 0 && end == 0;
    }

    /**
     * This method adds a new item to the end of the queue
     * @param str - a String to be added to the queue
     * Nothing is returned
     */
    public void enqueue(String str) {
        //Checks if queue is full first
        if (size() == maxSize){
            //If it is, then let the user know and do nothing
            System.out.println("Queue is full!");
        } else {
            //else add item to queue
            data[end%maxSize] = str;
            //Increase end by 1 position
            end++;
        }
    }

    /**
     * This method removes the first item in the queue
     * There are no parameters
     * @return a String which is the first item in the queue
     */
    public String dequeue(){
        //If you are removing the only item in the queue
        if (front + 1 == end){
            front++;
            String s = data[(front-1)%maxSize];
            //Set front and end to 0 since queue is now empty
            front = 0;
            end = 0;
            return s;
        } else if (!isEmpty()){
            //If the queue isn't empty and there is more than 1 item, then remove first item
            front++;
            return data[(front-1)%maxSize];
        }
        //If queue is empty let user know queue is empty and do nothing
        return "Queue is Empty!";
    }

    /**
     * This method returns the item that is in the front of the queue
     * There are no parameters
     * @return a String that is the item at the front of the queue
     */
    public String front(){
        if (!isEmpty()){
            //If list isn't empty, return item at front of queue
            return data[front%maxSize] + "";
        } else {
            //If list is empty, return String saying so
            return "Queue is Empty!";
        }
    }

    /**
     * This method returns the size of the queue by finding the difference between index of the first and last items
     * There are no parameters
     * @return an integer that represents the size of the queue
     */
    public int size(){
        return end - front;
    }

    /**
     * This method makes the queue empty by setting the front and end back to the beginning (0)
     * There are no parameters
     * Nothing is returned
     */
    public void makeEmpty(){
        front = 0;
        end = 0;
    }

    /**
     * This method returns all the items in the queue. Will be called when using printing queue
     * There are no parameters
     * @return a String which contains all the information of the queue
     */
    public String toString(){
        String info = "";
        for (int i = front; i < end; i++){
            info += data[i] + "  ";
        }
        return info;
    }
}
