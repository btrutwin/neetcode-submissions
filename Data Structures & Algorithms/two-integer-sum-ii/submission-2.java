class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // need to use two pointer approach for space 
        // have one pointer at end of numbers, one in front. 
        // loop pointer in front until end of array, looking for target. If yes, return indexes
        // if no, move forward pointer until end, then advance slow ptr and continue 
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        boolean found = false;
        while(found == false){
        if(numbers[left] + numbers[right] == target){
            result[0] = left + 1;
            result[1] = right + 1;
            found = true;
            return result;
        }
        if(numbers[left] + numbers[right] > target){
            right--;
        }
        else{
            left++;
        }
        }
        
        

        return result;
    }
}
