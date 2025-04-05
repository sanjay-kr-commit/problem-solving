class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int nullCount = 0;
        for ( ListNode l : lists ) if ( l == null ) nullCount++;
        while ( nullCount < lists.length ) {
            ListNode smallest = null ;
            int index = -1 ;
            for ( int i = 0 ; i < lists.length ; i++ ) {
                if ( lists[i] == null ) continue;
                if ( smallest == null || smallest.val > lists[i].val ) {
                    smallest = lists[i];
                    index = i;
                }
            }
            lists[index] = lists[index].next ;
            if ( lists[index] == null ) nullCount++ ;
            smallest.next = null ;
            cur.next = smallest ;
            cur = cur.next ;
        }
        return dummyHead.next ;
    }
}
