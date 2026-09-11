class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // if piles.length > h, can never eat all the bananas
        // upper bound is eating max size of piles bananas per hour 
        // lower bound is one banana per hour
        // the amount of time it takes to eat a pile is ceil(pile / k)
        // the amount of time it takes to eat all piles is sum of ceil(pile / k)
        int left = 1; int right = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > right){
                right = piles[i];
            }
        }
        
        int minTime = right;
        // check if mid works
        // if mid still works, move right to mid - 1 
        // if mid doesn't work, move left to mid + 1
        // keep track of lowest working mid and update 
        while(left <= right ){
            int mid = left + (right - left) / 2;
            if(hoursNeeded(piles, mid) <= h){
                minTime = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
            
        }
        return minTime;
    }
    private int hoursNeeded(int[] piles, int k){
        int hoursNeeded = 0;
        for(int i = 0; i < piles.length; i++){
            int pileTime = (piles[i] + k - 1)/ k;
            hoursNeeded = hoursNeeded + pileTime; 
        }
        return hoursNeeded;
    }
}
