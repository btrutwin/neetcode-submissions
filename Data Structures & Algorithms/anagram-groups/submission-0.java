class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sig = signatureMaker(strs[i]);

            if (map.containsKey(sig)) {
                map.get(sig).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(sig, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String signatureMaker(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : freq) {
            sb.append(count).append('#');
        }

        return sb.toString();
    }
}
