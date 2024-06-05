import java.util.Stack;

class StockSpanner {

    Stack<Long> stack = new Stack<>() ;

    public int next(int price) {
        int span = 1 ;
        while ( !stack.isEmpty() && (int)(long)(stack.peek()) <= price ) span += (int)(stack.pop() >>> 32 ) ;
        stack.push( ((((long)span)<<32) | (price & 0xFFFFFFFFL ) )) ;
        return span ;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */