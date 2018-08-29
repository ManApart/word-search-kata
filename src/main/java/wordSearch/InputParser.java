package wordSearch;

import java.util.List;

class InputParser {
    private String[] words;
    private char[][] grid;

    InputParser(List<String> input) {
        this.words = input.get(0).split(",");
        this.grid = parseGrid(input);
    }

    private char[][] parseGrid(List<String> input) {
        List<String> gridInput = input.subList(1, input.size());
        char[][] grid = new char[gridInput.size()][gridInput.size()];
        for (int y = 0; y < gridInput.size(); y++) {
            char[] row = gridInput.get(y).replaceAll(",", "").toCharArray();
            System.arraycopy(row, 0, grid[y], 0, row.length);
        }
        return grid;
    }

    String[] getSearchWords() {
        return words;
    }

    char[][] getGrid() {
        return grid;
    }
}
