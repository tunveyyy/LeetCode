class Solution {
    private class IntervalComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    };
    public int[][] merge(int[][] intervals) {
        
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        
        LinkedList<int[]> outputList = new LinkedList<>();
        
        for(int[] interval: intervals) {
            if(outputList.isEmpty() || outputList.getLast()[1] < interval[0] )
                outputList.add(interval);
            else {
                outputList.getLast()[1] = Math.max(outputList.getLast()[1],interval[1]);
            }
        }
        return outputList.toArray(new int[outputList.size()][]);
        
    }
}