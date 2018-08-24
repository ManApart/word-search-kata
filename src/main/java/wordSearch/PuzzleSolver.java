package wordSearch;

import wordSearch.search.DiagonalDescendingSearch;
import wordSearch.search.ForwardSearch;
import wordSearch.search.Search;
import wordSearch.search.VerticalSearch;

import java.util.Arrays;
import java.util.List;

public class PuzzleSolver {
    char[][] grid;

    public PuzzleSolver(char[][] grid) {
        this.grid = grid;
    }

    public Word find(String name) {
        List<Search> searches = Arrays.asList(
                new ForwardSearch(name),
                new VerticalSearch(name),
                new DiagonalDescendingSearch(name)
        );

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                for (Search search : searches) {
                    search.examine(grid[row][col], col, row);
                    if (search.isWordFound()) {
                        return new Word(name, search.getPosition().toArray(new Point[0]));
                    }
                }
            }
        }

        return null;
    }
}
