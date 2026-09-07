class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // need to make decreasing stack. add element. Check if element before is smaller.
        // if so, loop through stack, popping until empty or bigger element is found
        // only store index in stack, but compare with temp[i]
        // stack should be in decreasing order when index is called

        Stack<Integer> tempIdx = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (!tempIdx.isEmpty()) {
                while (!tempIdx.isEmpty() && temperatures[i] > temperatures[tempIdx.peek()]) {
                    result[tempIdx.peek()] = i - tempIdx.pop();
                }
            }

            tempIdx.push(i);
        }

        while (!tempIdx.isEmpty()) {
            result[tempIdx.pop()] = 0;
        }

        return result;
    }
}
