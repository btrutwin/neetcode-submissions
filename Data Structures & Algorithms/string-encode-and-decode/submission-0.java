class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            String s = strs.get(i);
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString(); 
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < str.length()){
            int length = 0;
        while(str.charAt(i) != '#'){
            length = length * 10 + (str.charAt(i) - '0');
            i++;
        }
        i++;
        StringBuilder curr = new StringBuilder();
        for(int j = 0; j < length; j++){
            curr.append(str.charAt(i));
            i++;
        }
        result.add(curr.toString());
        }

        return result;
    }
}
