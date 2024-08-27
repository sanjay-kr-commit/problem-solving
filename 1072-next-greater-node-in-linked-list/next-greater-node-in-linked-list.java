import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while ( cur != null ) {
            list.add(cur.val);
            cur = cur.next;
        }
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[list.size()];
        for ( int i = 0 ; i < list.size() ; i++ ) {
            while ( !stack.isEmpty() && list.get( stack.peek() ) < list.get( i )  ) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return result ;
    }
}