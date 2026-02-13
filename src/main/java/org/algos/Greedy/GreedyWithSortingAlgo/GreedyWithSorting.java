package org.algos.Greedy.GreedyWithSortingAlgo;

//      Greedy with Sorting is an algorithmic approach where we first sort
//      the data based on a specific criterion, then make locally optimal choices at each step.
//      The idea is that these optimal local decisions lead to a globally optimal solution.


//       Algorithm Explanation
//
//      Sort activities by ending time.
//
//      Always pick the activity that finishes earliest and does not
//      overlap with the previously selected one.
//
//      Repeat until no more activities can be selected.

import java.util.Arrays;

class Main {

    static class Activity {
        int start;
        int end;

        Activity(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        Activity[] a = {
                new Activity(1, 3),
                new Activity(2, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9)
        };

        Arrays.sort(a, (x, y) -> x.end - y.end);

        int cnt = 1;
        int lastEnd = a[0].end;

        for (int i = 1; i < a.length; i++) {
            if (a[i].start >= lastEnd) {
                cnt++;
                lastEnd = a[i].end;
            }
        }

        System.out.println(cnt);
    }
}


