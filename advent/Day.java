package advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

abstract class Solver {
    abstract void solve(ArrayList<String> lines);
}

public class Day {
    String day;

    Day(String dayNumber) {
        validateDayNumber(dayNumber);
        this.day = dayNumber;
    }

    private void validateDayNumber(String dayNumber) {
        if (!dayNumber.matches("\\d{2}")) {
            throw new IllegalArgumentException("Day number must be a two-digit number (e.g., 01, 02, ... 25).");
        }

        int day = Integer.parseInt(dayNumber);
        if (day < 1 || day > 25) {
            throw new IllegalArgumentException("Day number must be between 01 and 25.");
        }
    }

    public ArrayList<String> getInput() throws IOException {
        String s;
        String filePath = this.day + File.separator + "input.txt";
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((s = reader.readLine()) != null) {
                lines.add(s);
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read input file for Day " + day + ". Please ensure the file exists.");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return lines;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java Day <dayNumber>");
            return;
        }

        String dayNumber = args[0];
        Day day = new Day(dayNumber);
        ArrayList<String> lines = day.getInput();

        try {
            String solverClassName = "Day" + dayNumber + "Solver";
            Class<?> solverClass = Class.forName(solverClassName);
            Solver solver = (Solver) solverClass.getDeclaredConstructor().newInstance();
            solver.solve(lines);
        } catch (Exception e) {
            System.out.println("No solver found for Day " + dayNumber);
            e.printStackTrace();
        }
    }
}