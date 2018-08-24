import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {
    char[][] grid;

    public PuzzleSolver(char[][] grid) {
        this.grid = grid;
    }

    public Word find(String name) {

        Search search = new ForwardSearch(name);

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                search.examine(grid[row][col], col, row);
            }
        }

        List<Point> position = search.getPosition();
        if (position.size() == name.length()) {
            return new Word(name, position.toArray(new Point[0]));
        } else {
            position = verticalSearch(name);
            return new Word(name, position.toArray(new Point[0]));
        }

    }

    private List<Point> verticalSearch(String name) {
        List<Point> position = new ArrayList<>();

        int i = 0;
        for (int col = 0; col < grid[0].length; col++) {
            position.clear();
            i = 0;
            for (int row = 0; row < grid.length; row++) {
                char character = grid[row][col];
                if (character == name.charAt(i)) {
                    position.add(new Point(col, row));
                    i++;
                } else if (character == name.charAt(0)) {
                    position.clear();
                    position.add(new Point(col, row));
                    i = 1;
                } else {
                    position.clear();
                    i = 0;
                }
                if (position.size() == name.length()) {
                    break;
                }
            }
        }
        return position;
    }
}
