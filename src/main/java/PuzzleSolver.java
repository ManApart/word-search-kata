import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {
    char[][] grid;

    public PuzzleSolver(char[][] grid) {
        this.grid = grid;
    }

    public Word find(String name) {
        List<Point> position = forwardSearch(name);
        if (position.size() == name.length()){
            return new Word(name, position.toArray(new Point[0]));
        } else {
            position = verticalSearch(name);
            return new Word(name, position.toArray(new Point[0]));
        }

    }

    private List<Point> forwardSearch(String name) {
        List<Point> position = new ArrayList<>();

        int i;
        for (int row = 0; row < grid.length; row++) {
            position.clear();
            i = 0;
            for (int col = 0; col < grid[row].length; col++) {
                char character = grid[row][col];
                if (character == name.charAt(i)) {
                    position.add(new Point(col, row));
                    i++;
                } else {
                    position.clear();
                    i = 0;
                }
            }
            if (position.size() == name.length()) {
                break;
            }
        }
        return position;
    }

    private List<Point> verticalSearch(String name) {
        List<Point> position = new ArrayList<>();
        for (int i=0; i< name.length(); i++){
            position.add(new Point(0, i));
        }
        return position;
    }
}
