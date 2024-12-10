package d03;

import java.util.ArrayList;

import advent.Solver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Solver extends Solver {
    public Day03Solver() {
        super();
    }

    public int matchAndMultiply(String input) {
        int total = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int firstNumber = Integer.parseInt(matcher.group(1));
            int secondNumber = Integer.parseInt(matcher.group(2));
            total += firstNumber * secondNumber;
        }
        return total;
    }

    @Override
    public void solve1(ArrayList<String> lines) {
        String input = String.join("", lines); // Not efficient, but for now I except most inputs to be line-based
                                               // anyway.
        int total = matchAndMultiply(input);
        System.out.println(total);
    }

    @Override
    public void solve2(ArrayList<String> lines) {
        int total = 0;
        int lastEnd = 0;

        boolean isEnabled = true;

        String input = String.join("", lines); // Not efficient, but for now I except most inputs to be line-based
        // anyway.

        Pattern patterns = Pattern.compile("(do\\(\\)|don't\\(\\))");
        Matcher matcher = patterns.matcher(input);

        while (matcher.find()) {

            if (matcher.start() > lastEnd & isEnabled) {
                String firstInput = input.substring(lastEnd, matcher.start()).trim();
                total += matchAndMultiply(firstInput);
            }

            boolean isDisable = Pattern.matches("don't\\(\\)", matcher.group());

            if (isDisable) {
                isEnabled = false;
            } else {
                isEnabled = true;
            }

            lastEnd = matcher.end();
        }

        // Remaining text after the last pattern
        if (lastEnd < input.length() & isEnabled) {
            String remainingInput = input.substring(lastEnd).trim();
            total += matchAndMultiply(remainingInput);
        }

        System.out.println(total);
    }
}
