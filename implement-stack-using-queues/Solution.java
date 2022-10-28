import java.util.LinkedList;
import java.util.Queue;

// 0ms
class MyStack1 {

    Queue<Integer> stack ;

    public MyStack1() {
        stack = new LinkedList<>() ;
    }

    public void push(int x) {
        stack.add(x) ;
    }

    public int pop() {
        Queue<Integer> in = new LinkedList<>();
        int len = stack.size()-1 , element ;
        for ( int i= 0 ; i < len ; i++ ) {
            in.add( stack.poll() ) ;
        }
        element = stack.poll();
        stack.addAll(in);
        return  element ;
    }

    public int top() {
        Queue<Integer> in = new LinkedList<>();
        int element = -1 ;
        while ( ! stack.isEmpty() ) {
            element = stack.poll() ;
            in.add( element ) ;
        }
        stack.addAll(in);
        return  element ;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// 1ms
class MyStack {

    Queue<Integer> stack ;
    Queue<Integer> inverse ;

    public MyStack() {
        stack = new LinkedList<>() ;
    }

    public void push(int x) {
        stack.add(x) ;
    }

    public int pop() {
        inverse = new LinkedList<>();
        int len = stack.size()-1 , element ;
        for ( int i= 0 ; i < len ; i++ ) {
            inverse.add( stack.poll() ) ;
        }
        element = stack.poll();
        stack.addAll(inverse);
        return  element ;
    }

    public int top() {
        inverse = new LinkedList<>();
        int element = -1 ;
        while ( ! stack.isEmpty() ) {
            element = stack.poll() ;
            inverse.add( element ) ;
        }
        stack.addAll(inverse);
        return  element ;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */