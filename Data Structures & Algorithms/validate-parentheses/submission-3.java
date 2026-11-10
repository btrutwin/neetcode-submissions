class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() == true) {
                    return false;
                }
                Character top = stack.pop();
                if ((s.charAt(i) == ')' && top != '(') || (s.charAt(i) == ']' && top != '[')
                    || (s.charAt(i) == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
