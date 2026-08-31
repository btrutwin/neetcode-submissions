class Solution {
    public int characterReplacement(String s, int k) {
        // need to find a way to replace k chars to give longest repeating char in string 
        // sliding window problem
        // start at beginning of string and keep track of the most frequent char in window 
        // if length of window - maxfreqchar <= k, record L and expand window 
        // else, move left until that's satisfied again
        // how to keep track of most frequent char - HashMap with Char, Int
        // every time char gets seen, increment hashmap int value 
        HashMap<Character, Integer> chars = new HashMap<>();
        int left = 0; 
        int maxFreq = 0;
        int longestLength = 0; 
        for(int right = 0; right < s.length(); right++){
            if(!chars.containsKey(s.charAt(right))){
                chars.put(s.charAt(right), 1);
                if(chars.get(s.charAt(right)) > maxFreq){
                    maxFreq = 1; 
                }
            }
            else{
                int count = chars.get(s.charAt(right));
                count++;
                chars.put(s.charAt(right), count);
                if(chars.get(s.charAt(right)) > maxFreq){
                    maxFreq = chars.get(s.charAt(right));
                }
            }
            while((right - left + 1) - maxFreq > k){
                int count = chars.get(s.charAt(left));
                count--;
                chars.put(s.charAt(left), count);
                left++;
            }
            longestLength = Math.max(right - left + 1, longestLength);
        }

        return longestLength;
    }
}
