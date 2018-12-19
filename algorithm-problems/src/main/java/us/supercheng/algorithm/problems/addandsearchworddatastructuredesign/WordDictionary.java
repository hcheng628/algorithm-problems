package us.supercheng.algorithm.problems.addandsearchworddatastructuredesign;

class WordDictionary {

    private class Node {
        boolean isWord;
        Node[] data;

        public Node() {
            this.data = new Node [26];
        }
    }

    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;
        for(int i=0;i<word.length();i++) {
            char each = word.charAt(i);
            int index = each - 'a';
            if(curr.data[index] == null)
                curr.data[index] = new Node();
            curr = curr.data[index];
        }
        curr.isWord = true;
    }


    public boolean search(String word) {
        return this.search(this.root, word.toCharArray(), 0);
    }

    private boolean search(Node node, char [] word, int index) {
        if(index == word.length)
            return node.isWord;

        if(word[index] == '.') {
            for(int i=0;i<26;i++)
                if(node.data[i] != null && this.search(node.data[i], word, index+1))
                    return true;
            return false;
        } else
            return node.data[word[index] - 'a'] != null && search(node.data[word[index] - 'a'], word, index+1);
    }
}