
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashMap = new HashMap<>();
        Node dummyHead = new Node(0);
        Node curr = head ;
        Node dummy = dummyHead;
        while ( curr != null ) {
            dummy.next = new Node(curr.val) ;
            dummy = dummy.next;
            dummy.random = curr.random ;
            hashMap.put( curr , dummy ) ;
            curr = curr.next;
        }
        hashMap.put( null , null ) ;
        curr = dummyHead.next ;
        while ( curr != null ) {
                curr.random = hashMap.get(curr.random) ;
            curr = curr.next;
        }
        return dummyHead.next ;
    }
}
