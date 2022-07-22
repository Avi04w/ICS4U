package DataStructures.Stacks;

public class StackString {
    private int top;
    private String[] data;

    public StackString(){
        top = -1;
        data = new String[10];
    }

    public StackString(int n){
        top = -1;
        data  = new String[n];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(String s){
        if(!isFull()){
            top ++;
            data[top] = s;
        } else {
            System.out.println("Array is Full!");
        }
    }

    public String top() {
        if (isEmpty()){
            return data[top];
        } else {
            return "Empty";
        }
    }

    public int size(){
        return top + 1;
    }

    public String pop(){
        if (isEmpty()){
            top--;
            return data[top+1];
        }
        return "Empty";
    }

    public void makeEmpty(){
        top = -1;
    }

    public boolean isFull(){
        return size() == data.length;
    }

    public String toString(){
        String info = "Stack: ";
        for (int i = 0; i < top+1; i++){
            info += data[i] + " ";
        }
        return info;
    }
}
