class Solution {

    public Node copyRandomList(Node head) {
        if ( head == null ) return null ;
        Node dummy = new Node(0) ;
        int size = cloneList( head , dummy ) ;
        addRandomPointer( head , dummy.next , size );
        return dummy.next ;
    }

    int cloneList(Node head , Node clone ) {
        int size = 0 ;
        while ( head != null ) {
            clone.next = new Node(head.val) ;
            head = head.next ;
            clone = clone.next ;
            size++ ;
        }
        return size ;
    }

    void addRandomPointer(Node head , Node clone , int size ) {
        Node[] clonePointer = new Node[ size ] ;
        int i = 0 ;
        Node headClone = head , cloneClone = clone ;
        while ( i < size ) {
            headClone.val = i ;
            clonePointer[i] = cloneClone ;
            headClone = headClone.next ;
            cloneClone = cloneClone.next ;
            i++ ;
        }
        headClone = head ;
        cloneClone = clone ;
        while ( headClone != null ) {
            if ( headClone.random != null ) cloneClone.random = clonePointer[headClone.random.val] ;
            headClone = headClone.next ;
            cloneClone = cloneClone.next ;
        }
        headClone = head ;
        cloneClone = clone ;
        while ( headClone != null ) {
            headClone.val = cloneClone.val ;
            headClone = headClone.next ;
            cloneClone = cloneClone.next ;
        }

    }

}