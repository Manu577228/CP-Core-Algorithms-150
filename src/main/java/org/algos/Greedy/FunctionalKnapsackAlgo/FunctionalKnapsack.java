package org.algos.Greedy.FunctionalKnapsackAlgo;

//          Fractional Knapsack is a greedy algorithm where items can be taken
//          partially to maximize total value under a weight limit.
//          Items are selected based on the highest value-to-weight ratio first.
//          It guarantees an optimal solution because fractional choices are allowed.


//          Algorithm Explanation
//
//          Compute value / weight for each item
//
//          Sort items in descending order of ratio
//
//          Pick full items while possible
//
//          Take fraction of the next item if capacity is insufficient
//
//          Stop when knapsack is full

import java.util.*;

class FractionalKnapsack {

    static class Item {
        int weight;
        int value;

        Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        int capacity = 50;

        double result = fractionalKnapsack(items, capacity);
        System.out.println("Maximum value = " + result);
    }

    static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) ->
                Double.compare(
                        (double) b.value / b.weight,
                        (double) a.value / a.weight
                )
        );

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0)
                break;

            if (item.weight <= capacity) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                capacity = 0;
            }
        }

        return totalValue;
    }
}


