package wordSearch;

import java.util.List;

public class InputParser {
    private String[] words;
    private char[][] grid;

    public InputParser(List<String> input) {
        this.words = input.get(0).split(",");
        this.grid = parseGrid(input);
    }

    private char[][] parseGrid(List<String> input) {
        List<String> gridInput = input.subList(1, input.size());
        char[][] grid = new char[gridInput.size()][gridInput.size()];
        for (int y = 0; y < gridInput.size(); y++) {
            char[] row = gridInput.get(y).replaceAll(",", "").toCharArray();
            for (int x = 0; x < row.length; x++) {
                grid[x][y] = row[x];
            }
        }
        return grid;
    }

    public String[] getSearchWords() {
        return words;
    }

    public char[][] getGrid() {
        return grid;
    }
}
