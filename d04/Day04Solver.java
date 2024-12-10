package d04;

import java.util.ArrayList;

import advent.Solver;

public class Day04Solver extends Solver {
    public Day04Solver() {
        super();
    }

    enum Direction {
        STAY,
        FORWARD,
        BACKWARD
    }

    public static class Move {
        private int initialX;
        private int initialY;
        private int x;
        private int y;
        private Direction horizontalMove;
        private Direction verticalMove;

        public Move(int x, int y) {
            this.initialX = x;
            this.initialY = y;
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setMove(Direction horizontal, Direction vertical) {
            this.x = this.initialX;
            this.y = this.initialY;
            this.horizontalMove = horizontal;
            this.verticalMove = vertical;
        }

        public int moveHorizontal() {
            if (this.horizontalMove == Direction.FORWARD) {
                this.x = this.getX() + 1;
                return this.getX();
            } else if (this.horizontalMove == Direction.BACKWARD) {
                this.x = this.getX() - 1;
                return this.getX();
            } else {
                return this.getX();
            }
        }

        public int moveVertical() {
            if (this.verticalMove == Direction.FORWARD) {
                this.y = this.getY() + 1;
                return this.getY();
            } else if (this.verticalMove == Direction.BACKWARD) {
                this.y = this.getY() - 1;
                return this.getY();
            } else {
                return this.getY();
            }
        }

    }

    public boolean matchesPattern(ArrayList<char[]> matrix, Move currentPosition) {
        String XMAS = "XMAS";
        for (int i = 1; i < XMAS.length(); i++) {
            char XmasChar = XMAS.charAt(i);

            char currentChar = matrix.get(currentPosition.moveVertical())[currentPosition.moveHorizontal()];
            if (currentChar != XmasChar) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve1(ArrayList<String> lines) {
        int totalXmas = 0;
        // Split into a 2 dimensional array
        ArrayList<char[]> matrix = new ArrayList<>();
        for (String line : lines) {
            matrix.add(line.toCharArray());
        }

        for (int row = 0; row < matrix.size(); row++) {
            char[] currentRow = matrix.get(row);

            for (int col = 0; col < currentRow.length; col++) {
                char currentChar = currentRow[col];

                if (currentChar == 'X') {
                    Move newMove = new Move(col, row);

                    // Check horizontal
                    if (col + 3 < currentRow.length) {
                        newMove.setMove(Direction.FORWARD, Direction.STAY);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }

                    if (col >= 3) {
                        newMove.setMove(Direction.BACKWARD, Direction.STAY);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }

                    // Check vertical
                    if (row + 3 < matrix.size()) {
                        newMove.setMove(Direction.STAY, Direction.FORWARD);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }
                    if (row - 3 >= 0) {
                        newMove.setMove(Direction.STAY, Direction.BACKWARD);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }

                    // Check diagonal
                    if (row + 3 < matrix.size() & col + 3 < currentRow.length) {
                        newMove.setMove(Direction.FORWARD, Direction.FORWARD);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }

                    if (row + 3 < matrix.size() & col - 3 >= 0) {
                        newMove.setMove(Direction.BACKWARD, Direction.FORWARD);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }

                    if (row - 3 >= 0 & col + 3 < currentRow.length) {
                        newMove.setMove(Direction.FORWARD, Direction.BACKWARD);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }
                    if (row - 3 >= 0 & col - 3 >= 0) {
                        newMove.setMove(Direction.BACKWARD, Direction.BACKWARD);
                        boolean isMatch = matchesPattern(matrix, newMove);
                        if (isMatch) {
                            totalXmas++;
                        }
                    }
                }
            }

        }
        System.out.println(totalXmas);

    }

    @Override
    public void solve2(ArrayList<String> lines) {

    }
}
