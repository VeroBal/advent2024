package d01;

import advent.Solver;
import java.util.ArrayList;

public class Day01Solver extends Solver {

    public Day01Solver() {
        super();
    }

    // Method to parse input and return the two lists
    private Pair<ArrayList<Integer>, ArrayList<Integer>> parseInput(ArrayList<String> lines) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split("\\s+");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);

            list1.add(num1);
            list2.add(num2);
        }

        return new Pair<>(list1, list2);
    }

    private static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }

    @Override
    public void solve(ArrayList<String> lines) {
        QuickSort sorter = new QuickSort();
        int totalDistance = 0;

        Pair<ArrayList<Integer>, ArrayList<Integer>> columns = parseInput(lines);
        ArrayList<Integer> list1 = columns.getFirst();
        ArrayList<Integer> list2 = columns.getSecond();

        ArrayList<Integer> sortedList1 = sorter.sort(list1);
        ArrayList<Integer> sortedList2 = sorter.sort(list2);

        for (int i = 0; i < sortedList1.size(); i++) {
            Integer element1 = sortedList1.get(i);
            Integer element2 = sortedList2.get(i);
            int distance = Math.abs(element1 - element2);
            totalDistance += distance;
        }
        System.out.println(totalDistance);
    }
}
