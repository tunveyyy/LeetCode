class Solution {
    public int consecutiveNumbersSum(int N) {
        
        int result = 1, sum = 0, i = 2;
        while(sum < N) {
            sum += i - 1;
            if(N - sum > 0 && (N - sum) % i == 0) result++;
            i++;
        }
        return result;
    }
}