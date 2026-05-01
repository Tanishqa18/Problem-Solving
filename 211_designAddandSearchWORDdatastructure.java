class WordDictionary {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    private boolean searchHelper(String word, int pos, TrieNode node){
        if(node == null){
            return false;
        }
        if(pos == word.length()){
            return node.isEnd;
        }
        char ch = word.charAt(pos);
        if(ch=='.'){
            for (int i=0; i<26;i++){
                if(node.children[i] != null){
                    if(searchHelper(word, pos + 1, node.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }
        int index = ch-'a';
        return searchHelper(word,pos+1,node.children[index]);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
