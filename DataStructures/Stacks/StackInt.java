package DataStructures.Stacks;

public class StackInt {
    private int top;
    private int[] data;

    public StackInt(){
        top = -1;
        data = new int[10];
    }

    public StackInt(int n){
        top = -1;
        data  = new int[n];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int n){
        if(!isFull()){
            top ++;
            data[top] = n;
        } else {
            System.out.println("Full");
        }
    }

    public String top() {
        if (isEmpty()){
            return data[top]  + "";
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
            return data[top+1] + "";
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
