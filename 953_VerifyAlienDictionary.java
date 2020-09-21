class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] index = new int[26];
         for(int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        
        search:for(int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i+1];
            
            for(int k = 0; k < Math.min(a.length(), b.length()); k++) {
               if(a.charAt(k) != b.charAt(k)) {
                
                if(index[a.charAt(k) - 'a'] > index[b.charAt(k) - 'a'])
                    return false;
                continue search;
                } 
            }
            if(a.length() > b.length())
                return false;
            
        }
        return true;
    }
}