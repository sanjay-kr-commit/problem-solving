// took 1 ms
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(-1) ;
        ListNode node = mergedList ;
        while ( list1 != null || list2 != null ) {
            if ( list1 != null && list2 != null ) {
                if ( list1.val < list2.val ) {
                    node.next = new ListNode(list1.val) ;
                    list1 = list1.next ;
                } else {
                    node.next = new ListNode(list2.val) ;
                    list2 = list2.next ;
                }
            } else if ( list1 != null ) {
                node.next = new ListNode(list1.val) ;
                list1 = list1.next ;
            } else {
                node.next = new ListNode(list2.val) ;
                list2 = list2.next ;
            }
            node = node.next ;
        }
        return mergedList.next ;
    }
}

// took 1 ms
// avoid object creation
class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(-1) ;
        ListNode node = mergedList ;
        while ( list1 != null || list2 != null ) {
            if ( list1 != null && list2 != null ) {
                if ( list1.val < list2.val ) {
                    node.next = list1 ;
                    list1 = list1.next ;
                } else {
                    node.next = list2 ;
                    list2 = list2.next ;
                }
            } else if ( list1 != null ) {
                node.next = list1 ;
                list1 = list1.next ;
            } else {
                node.next = list2 ;
                list2 = list2.next ;
            }
            node = node.next ;
        }
        return mergedList.next ;
    }
}