    class Solution {
        public int reverse(int x) {            
            
            boolean negative = x < 0;
            x = negative ? x * -1: x;
            int reversedNum = 0;
            
            while(x > 0) {
                
                int pop = x % 10;
                x = x/10;
                if(reversedNum > Integer.MAX_VALUE/10 || (reversedNum == Integer.MAX_VALUE/10 && pop > 7))
                   
                   return 0;
                   
                   
                   if(reversedNum < Integer.MIN_VALUE/10 || (reversedNum == Integer.MIN_VALUE/10 && pop < -8) )
                    return 0;
                reversedNum = reversedNum* 10 + pop;
                
            }
            
            
            return negative ? reversedNum* -1 :reversedNum;
        }
    }

