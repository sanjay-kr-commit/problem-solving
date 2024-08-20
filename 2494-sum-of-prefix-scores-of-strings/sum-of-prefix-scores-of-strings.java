import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int n = words.length;
        for (String word : words) trie.insert(word);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = trie.startsWith(words[i])-n;
        return ans;
    }
}

class Trie {
    int root;
    List<TrieNode> list;
    
    public Trie() {
        root = 0;
        list = new ArrayList<>();
        list.add(new TrieNode());
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode temp = list.get(root);
        for( int i = 0; i < n; i++) {
            int curr = word.charAt(i)-'a';
            if( temp.getIndex(curr) == -1) {
                temp.addChar(curr, list.size());
                list.add(new TrieNode());
            }
            temp.increaseCount();
            temp = list.get(temp.getNext(curr));
        }
        temp.markEnd();
    }

    public int startsWith(String prefix) {
        int n = prefix.length();
        TrieNode temp = list.get(root);
        int count = 0;
        for(int i = 0; i < n; i++) {
            int curr = prefix.charAt(i)-'a';
            if(temp.getIndex(curr) == -1) return 0;
            int currCount = temp.getPrefixCount();
            // System.out.println(prefix.charAt(i)+" "+currCount);
            count += temp.getPrefixCount();
            temp = list.get(temp.getNext(curr));
        }
        count += temp.getPrefixCount();
        return count;
    }
}

class TrieNode {
    int endCount;
    int prefixCount;
    int[] map;
    TrieNode () {
        endCount = 0;
        prefixCount = 0;
        map = new int[26];
        Arrays.fill(map, -1);
    }

    int getIndex(int curr) {
        return map[curr];
    }

    int getNext(int curr) {
        return (map[curr] == -1)? -1 : map[curr];
    }

    void addChar(int curr, int index) {
        map[curr] = index;
    }

    void increaseCount() {
        prefixCount++;
    }

    void markEnd() {
        prefixCount++;
        endCount++;
    }

    int getPrefixCount() {
        return prefixCount;
    }
}