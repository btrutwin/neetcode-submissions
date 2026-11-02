class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));
        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }
        // now have first k elements in points.
        for (int i = k; i < points.length; i++) {
            int[] max = maxHeap.peek();
            int[] next = points[i];
            int currDis = max[0] * max[0] + max[1] * max[1];
            int nextDis = next[0] * next[0] + next[1] * next[1];
            if (nextDis < currDis) {
                maxHeap.poll();
                maxHeap.add(next);
            }
        }
        // now have max heap with only k closest elements
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
