import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        int len = 0 ;
        for ( String word : wordDict ) {
            insert( root , word );
            len++ ;
            len += word.length();
        }
        ArrayList<String> result = new ArrayList<>( wordDict.size() );
        traverse( root , root , s , result , new char[s.length()+len] , 0 , s.length() , 0 );
        return result ;
    }

    void traverse( TrieNode root, TrieNode node, String s , ArrayList<String> list , char [] buffer , int index , int len , int size ) {
        if ( node == null ) return;
        if ( index == len ) {
            if ( node.isEnd ) list.add( new String( buffer , 0 , size ) );
            return;
        }
        if ( node.isEnd ) {
            buffer[size] = ' ' ;
            traverse( root , root , s , list , buffer , index , len , size+1 );
        }
        int addr = s.charAt( index ) - 'a' ;
        buffer[size] = s.charAt( index ) ;
        traverse( root , node.child[addr] , s , list , buffer , index+1 , len , size+1 ) ;
    }

    void insert( TrieNode node , String string) {
        TrieNode current = node ;
        int index = 0 , len = string.length() ;
        while ( index < len ) {
            int addr = string.charAt(index++) - 'a' ;
            if ( current.child[addr] == null ) current.child[addr] = new TrieNode();
            current = current.child[addr];
        }
        current.isEnd = true ;
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }

}