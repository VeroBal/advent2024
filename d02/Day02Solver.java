package d02;

import java.util.ArrayList;
import java.util.Optional;

import advent.Solver;

public class Day02Solver extends Solver {
    public Day02Solver() {
        super();
    }

    public ArrayList<Integer> parseLine(String line) {
        ArrayList<Integer> levels = new ArrayList<>();
        String[] parts = line.split("\\s+");
        for (String part : parts) {
            levels.add(Integer.parseInt(part));
        }
        return levels;
    }

    private static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public Optional<Pair> unsafeLevel(ArrayList<Integer> levels) {
        boolean isIncreasing = true;
        for (int i = 1; i < levels.size(); i++) {
            int j = i - 1;
            int difference = levels.get(i) - levels.get(j);
            if (difference == 0 || difference > 3 || difference < -3) {
                Pair unsafeLevels = new Pair(i, j);
                return Optional.of(unsafeLevels);
            }
            boolean currentIncreasing = difference > 0;
            if (i == 1) {
                isIncreasing = currentIncreasing;
            } else if (isIncreasing != currentIncreasing) {
                Pair unsafeLevels = new Pair(i, j);
                return Optional.of(unsafeLevels);
            }
        }
        return Optional.empty();
    }

    @Override
    public void solve1(ArrayList<String> lines) {
        int safeLevels = 0;
        for (String line : lines) {
            ArrayList<Integer> levels = parseLine(line);
            boolean isSafe = unsafeLevel(levels).isEmpty();
            if (isSafe) {
                safeLevels++;
            }
        }

        System.out.println(safeLevels);
    }

    @Override
    public void solve2(ArrayList<String> lines) {
        int safeLevels = 0;
        for (String line : lines) {
            ArrayList<Integer> levels = parseLine(line);

            // First, check if the original sequence is already safe
            if (unsafeLevel(levels).isEmpty()) {
                safeLevels++;
                continue;
            }

            // Try removing each level one by one
            boolean foundSafeRemoval = false;
            for (int i = 0; i < levels.size(); i++) {
                ArrayList<Integer> listCopy = new ArrayList<>(levels);
                listCopy.remove(i);

                if (unsafeLevel(listCopy).isEmpty()) {
                    foundSafeRemoval = true;
                    break;
                }
            }

            if (foundSafeRemoval) {
                safeLevels++;
            }
        }

        System.out.println(safeLevels);
    }
}
