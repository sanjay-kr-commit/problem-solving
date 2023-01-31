import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> al = new ArrayList<>();
		for(int i = 0; i<words.length; i++){
			if(canPrint(words[i].toLowerCase()))
				al.add(words[i]);
		}
       String ans[] = al.toArray(new String[al.size()]);
		return ans;
    }
	
    static boolean canPrint(String str){
		String FR = "qwertyuiop";
		String SR = "asdfghjkl";
		String TR = "zxcvbnm";
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;

		for(int i = 0; i<str.length(); i++){
			if(FR.indexOf(str.charAt(i)) == -1){
				flag1 = false;
				break;
			}
		}
		for(int i = 0; i<str.length(); i++){
			if(SR.indexOf(str.charAt(i)) == -1){
				flag2 = false;
				break;
			}
		}
		for(int i = 0; i<str.length(); i++){
			if(TR.indexOf(str.charAt(i)) == -1){
				flag3 = false;
				break;
			}
		}
		if(flag1||flag2||flag3)
			return true;
		else
			return false;
    }
}

class Solution1 {
    public String[] findWords(String[] words) {
        HashSet<Character> row1 = "qwertyuiop".chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toCollection(HashSet::new)) ,
                row2 = "asdfghjkl".chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toCollection(HashSet::new)) ,
                row3 = "zxcvbnm".chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toCollection(HashSet::new)) ;
        ArrayList<String> ans = new ArrayList<>() ;
        for ( String s : words ) {
            HashSet<Character> allowed ;
            if ( row1.contains( s.charAt(0) ) || row1.contains((char) (s.charAt(0)+32) ) ) allowed = row1 ;
            else if ( row2.contains( s.charAt(0) ) || row2.contains((char) (s.charAt(0)+32) ) ) allowed = row2 ;
            else allowed = row3 ;
            for ( int i = 0 ; i <= s.length() ; i++ ) {
                if ( i == s.length() ) ans.add(s ) ;
                else if ( allowed.contains( s.charAt(i) ) || allowed.contains( (char)(s.charAt(i) + 32))) continue ;
                else break ;
            }
        }
        return Arrays.copyOf( ans.toArray(), ans.size(), String[].class);
    }
}
