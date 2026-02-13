package org.algos.Strings.PalindromicTreeAlgo;

//A Palindromic Tree (Eertree) is a data structure that stores
//        all distinct palindromic substrings of a string in linear time.
//        Each node represents one unique palindrome.

//                  Algorithm :
//
//        We build the tree while scanning the string left to right
//
//        Tree always starts with two special roots
//
//        Root -1 → imaginary palindrome of length -1
//
//        Root 0 → empty palindrome of length 0
//
//        For every new character:
//
//        Start from the last added palindrome
//
//        Follow suffix links until we can extend a palindrome
//
//        If extended palindrome already exists → just move last
//
//        Else:
//
//        Create a new node
//
//        Set its length
//
//        Set its suffix link
//
//        Total nodes = total distinct palindromes

import java.io.*;

class Main {

    static class Node {
        int len;
        int link;
        int[] next = new int[26];

        Node(int l) {
            len = l;
            link = 0;
        }
    }

    static Node[] tree = new Node[1000];
    static int size;
    static int last;
    static char[] s;
    static int n;

    static void init() {
        tree[0] = new Node(-1);
        tree[0].link = 0;
        tree[1] = new Node(0);
        tree[1].link = 0;
        size = 2;
        last = 1;
    }

    static void addChar(int pos) {
        int curr = last;
        while (true) {
            int currLen = tree[curr].len;
            if (pos - 1 - currLen >= 0 && s[pos] == s[pos - 1 - currLen])
                break;
            curr = tree[curr].link;
        }

        int c = s[pos] - 'a';
        if (tree[curr].next[c] != 0) {
            last = tree[curr].next[c];
            return;
        }

        tree[size] = new Node(tree[curr].len + 2);

        tree[curr].next[c] = size;

        if (tree[size].len == 1) {
            tree[size].link = 1;
        } else {
            int temp = tree[curr].link;

            while (true) {
                int tempLen = tree[temp].len;

                if (pos - 1 - tempLen >= 0 && s[pos] == s[pos - 1 - tempLen])
                    break;
                temp = tree[temp].link;
            }

            tree[size].link = tree[temp].next[c];
        }

        last = size;
        size++;
    }

    public static void main(String[] args) throws Exception {

        String str = "aba";

        s = str.toCharArray();

        n = s.length;

        init();

        for (int i = 0; i < n; i++) {
            addChar(i);
        }

        System.out.println("Total distinct palindromes = " + (size - 2));
    }
}
