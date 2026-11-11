
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int i) {
        // Base case: reached the end of the search string
        if (i == word.length()) {
            return node.isWord;
        }

        // Wildcard: explore every possible child
        if (word.charAt(i) == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null) {
                    if (dfs(node.children[j], word, i + 1)) {
                        return true;
                    }
                }
            }

            return false;
        }

        // Normal character: follow the corresponding child
        int index = word.charAt(i) - 'a';

        if (node.children[index] == null) {
            return false;
        }

        return dfs(node.children[index], word, i + 1);
    }
}
