package org.algos.Greedy.JobSchedulingAlgo;

//      Job Scheduling (Greedy) is an algorithm used to schedule jobs with
//      deadlines and profits such that the total profit is maximized,
//      assuming each job takes one unit of time.
//      The greedy choice is to always prioritize the job with the highest profit first.


//    Algorithm Explanation (extremely concise & clear)
//
//      Sort all jobs in descending order of profit
//
//      Create a timeline of slots up to the maximum deadline
//
//      For each job, place it in the latest free slot before its deadline
//
//      Skip the job if no slot is available
//
//      That’s it — greedy + smart placement.

import java.io.*;
import java.util.*;

class JobScheduling {

    static class Job {
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        Job[] jobs = {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job j : jobs) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int totaLProfit = 0;

        for (Job job : jobs) {
            for (int t = job.deadline; t > 0; t--) {
                if (slot[t] == -1) {
                    slot[t] = job.id;
                    totaLProfit += job.profit;
                    break;
                }
            }
        }

        out.print("Scheduled Jobs: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i] != -1) {
                out.print(slot[i] + " ");
            }
        }

        out.println();
        out.println("Total Profit: " + totaLProfit);

        out.flush();
    }
}