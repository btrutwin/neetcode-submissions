class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // piles[i] is the number of bananas at i 
        //  h = number of hours to eat the bananas
        // k is banana eating rate 
        // if pile has < k bananas, can finish eating the piles but can't move to next pile until hour is up 
        // return the minimum int k so that all bananas are eated within h hours
        // need to find slowest speed to eat all bananas in time constraint 
        // largest number we need to check is piles max bananas per hour 
        // lowest number needed to check is 1 
        // if we know a high speed works, and every high speed after also works, binary search 
        int right = -1; int left = 1; 
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > right){
                right = piles[i];
            }
        }
        // to binary, check mid speed. if it works, move right to mid, if not, move left to mid 
        // need a helper method to see how many bananas are needed at each piles[i]

        while(left <= right){
            int mid = left + (right - left) / 2;
            // mid works here 
            if(bananaHours(piles, mid) <= h){
                right = mid - 1;
            }
            // mid was too slow. hours > h so left has to move 
            else{
                left = mid + 1;
            }

        }
        return left; 
    }
    // returning number of hours needed to eat bananas with mid speed
    // if this number is <= h, we have a usable solution and can decrease mid
    // if this number is > h, we can't use this number and need to increase mid  
    private int bananaHours(int[] piles, int k){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            // divide piles[i] by k and go to ceiling 
            // k = 2, piles [i] = 7

            int currHours = (piles[i] + k - 1) / k;
            hours += currHours;
        }
        return hours; 
    }
}
