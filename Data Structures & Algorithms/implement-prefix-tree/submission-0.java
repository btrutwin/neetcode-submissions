class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        // need to start at root and see if word exists. Needs to be in the Trie and ends when word
        // ends
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false; 
            }
            curr = curr.children[index];
        }
        // only way we made it to this point is if all chars in word were in the Trie
        // now need to check if the last character, which is curr, is the end of the word
        if (curr.isWord == true) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        // similar implemenetation to search, but now we don't care about whether it's the end of word
        TrieNode curr = root; 
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false; 
            }
            curr = curr.children[index];
        }
        return true; // made it through all of prefix without hitting false
    }
}
