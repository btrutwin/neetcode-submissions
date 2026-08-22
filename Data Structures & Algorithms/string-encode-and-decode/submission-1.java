class Solution {

    public String encode(List<String> strs) {
       // need string builder
       // length, #, rest of string
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < strs.size(); i++){
        sb.append(strs.get(i).length());
        sb.append('#');
        sb.append(strs.get(i));
       }
       return sb.toString();        
    }

    public List<String> decode(String str) {
    // have string in [number][#][string] form
    // need to take length of string first
    // skip over #
    // loop through length found and add to stringbuilder 
    // return stringbuilder
    // keep track of index through all this
    // 5#Hello5#World
    List<String> decoded_strs = new ArrayList<>();
    int i = 0;
    int length = 0;
    while(i < str.length()){
    while(str.charAt(i) != '#'){
        length = length * 10 + (str.charAt(i) - '0');
        i++;
    }
    i++;
    StringBuilder sb = new StringBuilder();
    for(int j = 0; j < length; j++){
        sb.append(str.charAt(i));
        i++;
    }
     length = 0;
    decoded_strs.add(sb.toString());

    }
    return decoded_strs;

    }
}
