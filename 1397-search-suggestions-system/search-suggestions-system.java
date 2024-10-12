class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> suggestions = new ArrayList<>();
        helper(suggestions,products,searchWord,0,0,products.length-1);
        return suggestions;
    }
    private void helper(List<List<String>> suggestions,String[] products,String search,int idx,int start,int end){
        if(idx>=search.length()||start>end){
            return;
        }
        if(!suggestions.isEmpty()){
            char ch=search.charAt(idx);
            boolean flag = true;
            for(String s:suggestions.getLast()){
                if(idx>=s.length()||s.charAt(idx)!=ch){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int l = getEnd(products,search.charAt(idx),idx,start,end);
                suggestions.add(suggestions.getLast());
                helper(suggestions,products,search,idx+1,start,l);
                return;
            }
        }
        int s = getStart(products,search.charAt(idx),idx,start,end);
        if(s<0){
            for(int j=suggestions.size();j<search.length();j++){
                suggestions.add(new ArrayList<>());
            }
            return;
        }
        int e = getEnd(products,search.charAt(idx),idx,s,end);
        List<String> inner = new ArrayList<>();
        for(int i=s;i<=Math.min(s+2,e);i++){
            inner.add(products[i]);
        }
        suggestions.add(inner);
        helper(suggestions,products,search,idx+1,s,e);
    }
    private int getStart(String[] products,char target,int idx,int s,int e){
        int result = -1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(idx>=products[m].length()){
                s=m+1;
                continue;
            }
            char ch = products[m].charAt(idx);
            if(ch==target){
                result = m;
                e=m-1;
            } else if(ch<target){
                s=m+1;
            } else {
                e=m-1;
            }
        }
        return result;
    }
    private int getEnd(String[] products,char target,int idx,int s,int e){
        int result = -1;
        while(s <= e){
            int m = s + (e - s)/2;

            if(idx >= products[m].length()){
                s = m + 1;
                continue;
            }
            char ch = products[m].charAt(idx);

            if( ch == target){
                result = m;
                s = m + 1;
            }else if(ch < target){
                s = m + 1;
            }else {
                e = m - 1;
            }
        }

        return result;
    }
}