import java.util.HashMap;

class AuthenticationManager {
    
    node head;
    node end;
    HashMap<String, node> map; 
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        int expiryTime = currentTime + timeToLive;
        if(head == null) {
            head = new node(tokenId, expiryTime);
            map.put(tokenId, head);
            end = head;
        } else {
            end.next = new node(tokenId, expiryTime);
            end.next.prev = end;
            end = end.next;
            map.put(tokenId, end);
        }
    }

    public void renew(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId)) return;
        if(map.get(tokenId).time > currentTime) {
            int expiryTime = currentTime + timeToLive;

            node node = map.get(tokenId);
            if(node == end) {
                end.time = expiryTime;
                return;
            } else if(node == head) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.time = expiryTime;
            end.next = node;
            node.prev = end;
            end = end.next;
        }

    }

    public int countUnexpiredTokens(int currentTime) {
        while(head != null && head.time <= currentTime) {
            map.remove(head.val);
            head = head.next;
        }
        if(head == null) end = null;
        return map.size();
    }
}

class node {
    node next;
    node prev;
    String val;
    int time;

    node(String val, int time)
    {
        this.val = val;
        this.time = time;
    }
}