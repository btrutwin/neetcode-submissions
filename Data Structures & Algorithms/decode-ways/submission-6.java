class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        } // can't start with a 0
        if(s.length() == 1){
            return 1; 
        }
        // build first two steps
        // dp[i] is how many combinations can be made with the first i letters
        // if num is 1,2, add dp[i-1] + dp[i-2] to get next dp 
        // if num is 3-9, dp[i] is same as dp[i-1] since no new combos can be made 
        // if num is 0, dp[i] = dp[i-1] - dp[i-2]
        int prev1 = 2; int prev2 = 1; 
        int first = s.charAt(1) - '0';
        if(first == 0){
            int check = s.charAt(0) - '0';
            if(check > 2){
                return 0;
            }
            prev1 = 1; 
        }
        if(first > 6){
            prev1 = 1; 
        }
        
        for(int i = 2; i < s.length(); i++){
            
            int curr = s.charAt(i) - '0';
            int before = s.charAt(i - 1) - '0'; // 2
            int temp = prev1; 
            // if curr is 0
            if(curr == 0){ // current number is a 0
                if(before > 2 || before == 0){
                    return 0; // invalid
                }
                prev1 = prev2;
                prev2 = temp;
            }
            else if (before == 1 || (before == 2 && curr <= 6)){ // number before curr is 1 or 2, best case 
                prev1 = prev1 + prev2; 
                prev2 = temp;
            }
            else{
                prev2 = temp; // prev1 doesn't need to update 
            }
        }
        return prev1; 
    }
}
