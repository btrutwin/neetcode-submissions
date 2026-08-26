class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // need to loop through numbers. add number and index to HashMap. 
        // check if there is a number that is target - numbers[i] in the map. 
        // if yes, return that numbers index, as well as i. if no, continue 
        // check HashMap before adding to prevent same element from being used twice
        // target = 3, numbers = [1,2,3,4]
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        map.put(numbers[0], 1);
        int neededNum = 0;
        // map = {(1, 1)}
        for(int i = 1; i < numbers.length; i++){
            neededNum = target - numbers[i];
            // 3 - 2 = 1
            if(map.containsKey(neededNum)){
                result[1] = i + 1;
                result[0] = map.get(neededNum);
                return result;
            }
            else{
                map.put(numbers[i], i + 1);
            }
        }
        return result;
    }
}
