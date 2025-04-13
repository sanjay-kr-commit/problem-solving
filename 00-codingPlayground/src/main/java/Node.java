class Node {
    int val;
    Node next;
    Node random;
    public Node prev;
    public Node child;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node [val=" + val + ", next=" + ((next==null)?"null":next) + ", random=" + ((random==null)?"null":random) + ", child=" + ((child==null)?"null":child) +  "]";
    }
}