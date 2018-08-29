package wordSearch;

import wordSearch.search.*;

import java.util.Arrays;
import java.util.List;

public class PuzzleSolver {
    private char[][] grid;

    public PuzzleSolver(char[][] grid) {
        this.grid = grid;
    }

    public Word find(String word) {
        List<Search> searches = Arrays.asList(
                new HorizontalSearch(word),
                new VerticalSearch(word),
                new DiagonalAscendingSearch(word),
                new DiagonalDescendingSearch(word)
        );

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                for (Search search : searches) {
                    search.examine(grid[row][col], col, row);
                    if (search.isWordFound()) {
                        return new Word(word, search.getPosition().toArray(new Point[0]));
                    }
                }
            }
        }
        throw new WordNotFoundException(word + " not found in puzzle.");
    }
}
