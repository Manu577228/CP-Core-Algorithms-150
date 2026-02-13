package org.algos.Trees.PersistentSegmentTreeAlgo;

//A Persistent Segment Tree is a segment tree where every update
//        creates a new version, while old versions remain unchanged and accessible.
//        It achieves this by copying only the nodes on the update path.

//         How the Algorithm Works
//
//        Each node represents a range [l, r] and stores some aggregate (here: sum)
//
//        Initial build creates version 0
//
//        On update:
//
//        Only nodes along the update path are newly created
//
//        All untouched nodes are reused (shared)
//
//        Each update returns a new root, representing a new version
//
//        Queries can be done on any version independently

//Example Used
//        Array = [1, 2, 3, 4]
//        Operation → Update index 1 to 10

import java.io.*;
import java.util.*;

class PersistentSegmentTree {

    static class Node {
        int sum;
        Node left;
        Node right;

        Node(int s, Node l, Node r) {
            sum = s;
            left = l;
            right = r;
        }
    }

    static Node build(int l, int r, int[] a) {
        if (l == r) {
            return new Node(a[l], null, null);
        }

        int m = (l + r) >> 1;

        Node left = build(l, m, a);
        Node right = build(m + 1, r, a);

        return new Node(left.sum + right.sum, left, right);
    }

    static Node update(Node prev, int l, int r, int idx, int val) {
        if (l == r) {
            return new Node(val, null, null);
        }

        int m = (l + r) >> 1;

        if (idx <= m) {
            Node newLeft = update(prev.left, l, m, idx, val);
            return new Node(newLeft.sum + prev.right.sum, newLeft, prev.right);
        } else {
            Node newRight = update(prev.right, m + 1, r, idx, val);
            return new Node(prev.left.sum + newRight.sum, prev.left, newRight);
        }
    }

    static int query(Node node, int l, int r, int ql, int qr) {
        if (node == null || ql > r || qr < l) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            return node.sum;
        }

        int m = (l + r) >> 1;

        return query(node.left, l, m, ql, qr) +
                query(node.right, m + 1, r, ql, qr);
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};

        Node version0 = build(0, 3, a);

        Node version1 = update(version0, 0, 3, 1, 10);

        System.out.println(query(version0, 0, 3, 0, 3));
        System.out.println(query(version1, 0, 3, 0, 3));
    }
}
