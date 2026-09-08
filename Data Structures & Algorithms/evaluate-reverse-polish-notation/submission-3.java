class Solution {
    public int evalRPN(String[] tokens) {
        // stack problem. 
        // push values on stack if they aren't an operator 
        // when operator is hit, pop top value and use operator on second popped value
        // add new number to stack and continue until tokens is finished 
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int newNum = num1 + num2;
                stack.push(newNum);
            }
            else if(tokens[i].equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int newNum = num1 - num2;
                stack.push(newNum);
            }
            else if(tokens[i].equals("*")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int newNum = num1 * num2;
                stack.push(newNum);
            }
            else if(tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int newNum = num1 / num2;
                stack.push(newNum);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        int result = stack.pop();
        return result;
    }
}
