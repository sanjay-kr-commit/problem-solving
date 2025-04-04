class Solution {
    public Node flatten(Node head) {
        if ( head == null ) return null;
        flatten(head.next);
        if ( head.child != null ) {
            Node next = head.next;
            Node prev = head ;
            Node curr = head.child ;
            head.child = null ;
            while ( curr != null ) {
                if ( curr.child != null ) flatten(curr) ;
                prev.next = curr ;
                curr.prev = prev ;
                prev = prev.next ;
                curr = curr.next ;
            }
            prev.next = next ;
            if ( next != null ) next.prev = prev ;
        }
        return head ;
    }
}