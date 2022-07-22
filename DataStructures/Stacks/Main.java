package DataStructures.Stacks;

public class Main {
    public static void main(String[] args){
        StackInt s = new StackInt();
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(8);
        System.out.println(s.top());
        System.out.println(s.size());
        s.push(7);
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
        s.push(6);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.isEmpty());
        s.makeEmpty();
        System.out.println(s.isEmpty());
    }
}
