import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {
    char[][] grid;

    public PuzzleSolver(char[][] grid) {
        this.grid = grid;
    }


    public Word find(String name) {
        List<Point> position = new ArrayList<>();

        int i = 0;
        for (int col = 0; col < grid[0].length; col++) {
            char character = grid[0][col];
            if (character == name.charAt(i)) {
                position.add(new Point(col, 0));
                i++;
            } else {
                position.clear();
                i = 0;
            }
        }

        return new Word(name, position.toArray(new Point[0]));
    }
}
