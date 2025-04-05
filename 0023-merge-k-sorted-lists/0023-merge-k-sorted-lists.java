class Solution {

    static class pair {
        int x;
        int node ;
        public pair(int x, int node) {
            this.x = x;
            this.node = node;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists.length == 0 ) return null;
        if ( lists.length == 1 ) return lists[0];

        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for ( ListNode list : lists ) {
            ListNode curr = list;
            while ( curr != null ) {
                max = Math.max(max, curr.val);
                min = Math.min(min, curr.val);
                curr = curr.next;
            }
        }

        pair [] nodes = new pair[max - min + 1];
        for ( ListNode list : lists ) {
            ListNode curr = list;
            while ( curr != null ) {
                if ( nodes[curr.val-min] == null ) nodes[curr.val-min] = new pair(0, curr.val);
                nodes[curr.val-min].x++ ;
                curr = curr.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for ( pair node : nodes ) {
            if ( node == null ) continue;
            for ( int i = 0 ; i < node.x ; i++ ) {
                curr.next = new ListNode(node.node);
                curr = curr.next;
            }
        }
        curr.next = null ;
        return dummy.next;
    }
}