class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new Node();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return true;
    }
}
