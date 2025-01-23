import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList <List<String>> result = new ArrayList<>();
        
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        
        for ( String str : strs ) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            if ( map.containsKey(sorted) ) map.get(sorted).add(str);
            else map.put(sorted, new ArrayList<>( List.of(str) ));
        }
        
        for ( Map.Entry<String, ArrayList<String>> entry : map.entrySet() ) {
            result.add(new ArrayList<>(entry.getValue()));
        }
        
        return result ;
    }
}