class TimeMap {
    private HashMap<String, List<AbstractMap.SimpleEntry<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>()); // Create list if it doesn't exist
        map.get(key).add(new AbstractMap.SimpleEntry<>(timestamp, value)); // Add to the list
    }
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<AbstractMap.SimpleEntry<Integer, String>> list = map.get(key);
        int index = binarySearch(list, timestamp);

        if (index == -1) {
            return "";
        }

        return list.get(index).getValue();
    }

    private int binarySearch(List<AbstractMap.SimpleEntry<Integer, String>> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midTimestamp = list.get(mid).getKey();

            if (midTimestamp <= timestamp) {
                result = mid; // Could be the answer, search right
                left = mid + 1;
            } else {
                right = mid - 1; // Too big, search left
            }
        }
        return result;
    }
}
