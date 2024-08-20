import java.util.ArrayList;
import java.util.List;

class Solution {
    
    Trie root;
    List<String> res;

    public List<String> removeSubfolders(String[] folder) {
        //sort the folders by length
        List<String>[] lists = new List[101];
        for (int i = 0; i < lists.length; ++i) lists[i] = new ArrayList<>();
        for (String s : folder) lists[s.length()].add(s);
        root = new Trie();
        res = new ArrayList<>();
        for (List<String> list : lists) for (String path : list) {
            if ( insert( path, root, 0 ) ) res.add(path);
        }
        return res;
    }

    public boolean insert(String path, Trie cur, int index) {
        if ( index == path.length() ) {
            cur.isEnd = true;
            return true;
        }
        char c = path.charAt( index );
        int p = c == '/' ? 26 : c - 'a';
        if ( cur.next[p] == null ) cur.next[p] = new Trie();
        else if (cur.next[p].isEnd && index < path.length() - 1 && path.charAt(index + 1) == '/') return false;
        return insert(path, cur.next[p], index + 1);
    }

    class Trie {
        Trie[] next;
        boolean isEnd;
        public Trie() {
            next = new Trie[27];
        }
    }
    
}