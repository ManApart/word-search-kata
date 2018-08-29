package wordSearch.search;

import org.junit.Assert;
import org.junit.Test;
import wordSearch.Point;
import wordSearch.PuzzleSolver;
import wordSearch.Word;

public class DiagonalAscendingSearchTest {

    private void assertEquals(Word solution, String name, Point[] position) {
        Assert.assertEquals(name, solution.getName());

        Assert.assertEquals(position.length, solution.getPosition().length);
        for (int i = 0; i < position.length; i++) {
            Assert.assertTrue(position[i].equals(solution.getPosition()[i]));
        }
    }

    @Test
    public void simplestPossible() {
        char[][] grid = {
                {'A','A','A','U'},
                {'A','A','L','A'},
                {'A','U','A','A'},
                {'S','A','A','A'}
        };
        Point[] expectedPosition = {
                new Point(0, 3),
                new Point(1, 2),
                new Point(2, 1),
                new Point(3, 0)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SULU");

        assertEquals(solution, "SULU", expectedPosition);
    }

    @Test
    public void backwardsSearch() {
        char[][] grid = {
                {'A','A','A','S'},
                {'A','A','U','A'},
                {'A','L','A','A'},
                {'U','A','A','A'}
        };
        Point[] expectedPosition = {
                new Point(3, 0),
                new Point(2, 1),
                new Point(1, 2),
                new Point(0, 3)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SULU");

        assertEquals(solution, "SULU", expectedPosition);
    }



}
