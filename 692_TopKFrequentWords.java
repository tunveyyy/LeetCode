class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> heap = new PriorityQueue<String>(
        (a,b) -> map.get(a) == map.get(b) ? (b).compareTo(a) : map.get(a) - map.get(b) );
        
        for(String word: map.keySet()) {
            heap.add(word);
            if(heap.size() > k) heap.poll();
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        while(!heap.isEmpty()) ans.add(heap.poll());
        
        Collections.reverse(ans);
        return ans;
    }
}