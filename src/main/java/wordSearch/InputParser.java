package wordSearch;

import java.util.List;

public class InputParser {
    private String[] words;
    private char[][] grid;

    public InputParser(List<String> input) {
        this.words = input.get(0).split(",");

        grid = new char[input.size()-1][input.size()-1];
        for (int y=1; y<input.size(); y++){
            char[] row = input.get(y).replaceAll(",", "").toCharArray();
            for (int x=0; x<row.length; x++){
                grid[x][y-1] = row[x];
            }
        }
    }

    public String[] getSearchWords() {
        return words;
    }

    public char[][] getGrid() {
        return grid;
    }
}
