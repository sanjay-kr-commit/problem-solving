import java.util.Stack;

class StockSpanner {

    int [][] stack = new int[ 10010 ][] ;
    int size = -1 ;

    public int next(int price) {
        int span = 1 ;
        while ( size > -1 && stack[ size ][1] <= price ) span += stack[size--][0] ;
        stack[++size] = new int[]{ span , price } ;
        return span ;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */