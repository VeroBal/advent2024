
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Solver {
    void solve(ArrayList<String> lines) {

    }
}

public class Day {
    String day;

    Day(String dayNumber) {
        this.day = dayNumber;
    }

    public ArrayList<String> getInput() throws IOException {
        String s;
        String filePath = this.day + "/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> lines = new ArrayList<>();
        while ((s = reader.readLine()) != null) {
            lines.add(s);
        }
        reader.close();
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
        Solver solver = new Solver();
        solver.solve(lines);
    }
}