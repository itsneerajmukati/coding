package trie;

import java.util.Arrays;

public class Trie {
    
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            //create empty child node
            Arrays.fill(children, null);
        }
    }

    static TrieNode root;

    static void insert(String key) {
        int level;
        int length= key.length();
        int index;
        TrieNode tn = root;

        for(level=0;level<length;level++) {
            index = key.charAt(level)-'a';
            if(tn.children[index]==null) {
                tn.children[index]= new TrieNode();
            }
            tn = tn.children[index];
        }
        tn.isEndOfWord=true;
    }

    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl.isEndOfWord);
    }

    public static void main(String[] args) {
        root = new TrieNode();
        insert("neeraj");
        System.out.println(search("neeraj"));
    }

}
