public class Solution {
    
    public boolean isPalindrome(int num){
         
        if(num < 0 || (num % 10 == 0 && num != 0))
            return false;
        
        int revertedNumber = 0;
        while(num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }
          
        return x == revertedNumber || x == revertedNumber / 10;
       }
        
    }
 class 9_PalindromNumber {
    
}
