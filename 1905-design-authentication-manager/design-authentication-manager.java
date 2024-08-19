import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {

    private int timeout ;

    HashMap<String,Integer> tokens = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeout = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeout );
    }

    public void renew(String tokenId, int currentTime) {
        int expires = tokens.getOrDefault(tokenId, 0);
        if (expires > currentTime) tokens.put(tokenId, currentTime + timeout);
    }

    public int countUnexpiredTokens(int currentTime) {
        Map.Entry<String,Integer>[] removeTokens = new Map.Entry[tokens.size()];
        int filledEntry = 0 ;
        for (Map.Entry<String,Integer> token : tokens.entrySet() ) {
            if ( token.getValue() <= currentTime ) removeTokens[filledEntry++] = token ;
        }
        for ( int i = 0 ; i < filledEntry ; i++ ) tokens.remove( removeTokens[i].getKey() );
        return tokens.size();
    }

}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */