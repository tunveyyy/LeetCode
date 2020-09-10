class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
       
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();
        
        String str = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = str.split("\\s+");

        for(String word: banned) {
            bannedWords.add(word);
        }

        for(String word: words) {
            
            if(!bannedWords.contains(word))
                map.put(word, map.getOrDefault(word, 0) + 1);
            
        }
        
        String output = null;
        for(String word : map.keySet()) {
            if(output == null || map.get(word) > map.get(output))
                output = word;
        }
        return output;
        
    }
}