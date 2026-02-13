package org.algos.Stacks.ValidParantheses;

//A string of parentheses is valid if every opening bracket
//has a matching closing bracket
//and brackets are closed in the correct order.

//Algorithm Explanation
//
//Use a stack to track opening brackets.
//
//Traverse the string character by character.
//
//If the character is an opening bracket → push it to the stack.
//
//If the character is a closing bracket:
//
//Stack must NOT be empty.
//
//Top of stack must be the matching opening bracket.
//
//If matched → pop from stack, else → invalid.
//
//After traversal:
//
//Stack must be empty for the string to be valid.

import java.util.*;

class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;

                char top = st.pop();

                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        return st.isEmpty();
    }
}