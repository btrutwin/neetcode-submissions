class Solution {
    public int evalRPN(String[] tokens) {
        // need to have two stacks. One for operands, other for numbers. start by making the two
        // stacks
        Stack<Integer> stack = new Stack<>();
        // push 1 onto stack, then 2. See +. compute, push back onto stack. repeat until loop done
        for (int i = 0; i < tokens.length; i++) {
            String top = tokens[i];
            if (top.equals("/")) {
                int firstNum = stack.peek();
                // maybe have to handle div by 0
                stack.pop();
                int secondNum = stack.peek();
                stack.pop();
                int sumNum = secondNum / firstNum;
                stack.push(sumNum);
            }
            else if (top.equals("*")) {
                int firstNum = stack.peek();
                // maybe have to handle div by 0
                stack.pop();
                int secondNum = stack.peek();
                stack.pop();
                int sumNum = secondNum * firstNum;
                stack.push(sumNum);
            }
            else if (top.equals("+")) {
                int firstNum = stack.peek();
                // maybe have to handle div by 0
                stack.pop();
                int secondNum = stack.peek();
                stack.pop();
                int sumNum = secondNum + firstNum;
                stack.push(sumNum);
            }
            else if (top.equals("-")) {
                int firstNum = stack.peek();
                // maybe have to handle div by 0
                stack.pop();
                int secondNum = stack.peek() ;
                stack.pop();
                int sumNum = secondNum - firstNum;
                stack.push(sumNum);
            }
            else{
            stack.push(Integer.parseInt(tokens[i]));
            }
        }
        int result = stack.peek();
        return result;
    }
}
