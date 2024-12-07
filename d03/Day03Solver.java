package d03;

import java.util.ArrayList;

import advent.Solver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Solver extends Solver {
    public Day03Solver() {
        super();
    }

    @Override
    public void solve1(ArrayList<String> lines) {
        int total = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        String input = String.join("", lines); // Not efficient, but for now I except most inputs to be line-based
                                               // anyway.
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int firstNumber = Integer.parseInt(matcher.group(1));
            int secondNumber = Integer.parseInt(matcher.group(2));
            total += firstNumber * secondNumber;
        }
        System.out.println(total);
    }

    @Override
    public void solve2(ArrayList<String> lines) {
    }
}
