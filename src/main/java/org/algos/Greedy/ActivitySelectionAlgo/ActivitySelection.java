package org.algos.Greedy.ActivitySelectionAlgo;

//      Activity Selection Algorithm is a greedy algorithm used to select
//      the maximum number of non-overlapping activities from a given set,
//      where each activity has a start time and finish time.
//      The strategy is to always pick the activity that finishes earliest.


//      Algorithm Explanation
//
//      Sort all activities by their finish time
//
//      Select the first activity (earliest finish)
//
//      For remaining activities, select an activity only if its start time
//      ≥ last selected activity’s finish time
//
//      Continue till all activities are checked
//
//       Greedy choice works because finishing earlier leaves more room for future activities.

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

    public static void main(String[] args) throws Exception {
        Activity[] arr = {
                new Activity(1, 3),
                new Activity(2, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9)
        };

        Arrays.sort(arr, (a, b) -> a.end - b.end);

        int count = 1;
        int lastEnd = arr[0].end;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start >= lastEnd) {
                count++;
                lastEnd = arr[i].end;
            }
        }

        System.out.println(count);
    }
}


