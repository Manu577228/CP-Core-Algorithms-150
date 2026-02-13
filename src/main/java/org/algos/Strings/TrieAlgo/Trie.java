package org.algos.Strings.TrieAlgo;

//A Trie is a tree-based data structure used to store strings where
//        each node represents a character.
//        It enables fast prefix-based search and insertion.

//How Trie Algorithm Works :
//
//        Start from a root node (empty character).
//
//        Each edge represents one character.
//
//        Insert word character by character.
//
//        If a character node doesn’t exist → create it.
//
//        Mark the last character of a word as end-of-word.
//
//        For search, traverse characters sequentially.
//
//        If traversal breaks → word does not exist.
//
//        If traversal ends and end-of-word is true → word exists.

//example: insert "cat" and "car", then search "cat"

import java.io.*;
import java.util.*;

class TrieExample {

    static class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }

    static TrieNode root = new TrieNode();

    static void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (cur.child[idx] == null) {
                cur.child[idx] = new TrieNode();
            }

            cur = cur.child[idx];
        }

        cur.isEnd = true;
    }

    static boolean search(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (cur.child[idx] == null) {
                return false;
            }

            cur = cur.child[idx];
        }

        return cur.isEnd;
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        insert("cat");
        insert("car");

        out.println(search("cat"));
        out.println(search("cap"));

        out.flush();
    }
}