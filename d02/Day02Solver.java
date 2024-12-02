package d02;

import java.util.ArrayList;

import advent.Solver;

public class Day02Solver extends Solver {
    public Day02Solver() {
        super();
    }

    public ArrayList<Integer> parseLine(String line){
        ArrayList<Integer> levels = new ArrayList<>();
        String[] parts = line.split("\\s+");
        for (String part : parts) {
            levels.add(Integer.parseInt(part));
        }
        return levels;
    }

    @Override
    public void solve1(ArrayList<String> lines) {
        int safeLevels = 0;
        for(String line: lines){
            ArrayList<Integer> levels = parseLine(line);
            boolean isIncreasing = true;
            boolean isSafe = true;
            for(int i=1; i<levels.size(); i++){
                int j=i-1;
                int difference = levels.get(i) - levels.get(j);
                if(difference == 0 || difference > 3 || difference < -3){
                    isSafe = false;
                    break;
                } 
                boolean currentIncreasing = difference > 0;
                if(i == 1){
                    isIncreasing = currentIncreasing;
                }
                else if(isIncreasing != currentIncreasing){
                    isSafe = false;
                    break;
                }
            }
            if(isSafe){
                safeLevels++;
            }
        }

        System.out.println(safeLevels);
    }

    @Override
    public void solve2(ArrayList<String> lines) {
    }
}
