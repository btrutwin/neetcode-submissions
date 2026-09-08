class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position, descending — process the car closest to the target first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // If this car's time is greater than the fleet ahead of it,
            // it never catches up — it forms its own new, distinct fleet.
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Otherwise (time <= stack.peek()), it catches up and merges
            // into the fleet ahead — don't push anything new.
        }

        return stack.size();
    }
}