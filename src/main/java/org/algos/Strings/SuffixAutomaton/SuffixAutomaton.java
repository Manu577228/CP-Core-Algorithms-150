package org.algos.Strings.SuffixAutomaton;

//Suffix Automaton (SAM) is a compressed automaton that
//        represents all substrings of a string.
//        It allows substring queries in linear time construction.

//How the Algorithm Works :
//
//        Build the automaton character by character
//
//        Each state represents a set of substrings with:
//
//        len → length of longest substring in that state
//
//        link → suffix link (like fallback)
//
//        next[] → transitions by characters
//
//        While adding a new character:
//
//        Create a new state for extended substrings
//
//        Update transitions backward using suffix links
//
//        If conflict occurs, create a clone state to preserve correctness
//
//        End result compactly stores all substrings


import java.io.*;
import java.util.*;

class Main {

    static class State {
        int len;
        int link;
        int[] next = new int[26];

        State() {
            Arrays.fill(next, -1);
        }
    }

    static State[] st;
    static int sz;
    static int last;

    static void saInit() {
        st = new State[100];
        st[0] = new State();
        st[0].len = 0;
        st[0].link = -1;
        sz = 1;
        last = 0;
    }

    static void saExtend(char c) {
        int cur = sz++;
        st[cur] = new State();
        st[cur].len = st[last].len + 1;

        int p = last;
        int x = c - 'a';

        while (p != -1 && st[p].next[x] == -1) {
            st[p].next[x] = cur;
            p = st[p].link;
        }

        if (p == -1) {
            st[cur].link = 0;
        } else {
            int q = st[p].next[x];
            if (st[p].len + 1 == st[q].len) {
                st[cur].link = q;
            } else {
                int clone = sz++;
                st[clone] = new State();
                st[clone].len = st[p].len + 1;
                st[clone].next = st[q].next.clone();
                st[clone].link = st[q].link;

                while (p != -1 && st[p].next[x] == q) {
                    st[p].next[x] = clone;
                    p = st[p].link;
                }

                st[q].link = st[cur].link = clone;
            }
        }

        last = cur;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s = "aba";
        saInit();

        for (int i = 0; i < s.length(); i++) {
            saExtend(s.charAt(i));
        }

        out.println("States Count: " + sz);
        out.println("Each state represents substrings of \"aba\"");

        out.flush();
    }
}

