class Solution {
    public int[][] kClosest(int[][] points, int K) {
            
        int[][] res = new int[K][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->
            (-(a[0]*a[0] + a[1]*a[1]) + (b[0]*b[0] + b[1]*b[1])));
        
        int index = 0 ;
        
        for(int i = 0; i < K; i++) {
            heap.add(points[i]);
        }
        
        for(int i = K; i < points.length; i++) {
            if(distance(heap.peek()) > distance(points[i])) {
                heap.poll();
                heap.add(points[i]);
            }
        }
        
        while(index < K) {
            res[index++] = heap.poll();
        }
        
        return res;
    }
    public int distance(int[] a) {
        return a[0]*a[0] + a[1]*a[1];
    }
}