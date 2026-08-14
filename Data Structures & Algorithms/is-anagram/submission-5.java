class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> stringChars = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            stringChars.put(c, stringChars.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(stringChars.containsKey(c) == false){
                return false;
            }
            stringChars.put(c, stringChars.getOrDefault(c, 0) - 1);

            if(stringChars.get(c) < 0){
                return false;
            }
        }
        return true;
    }
}
