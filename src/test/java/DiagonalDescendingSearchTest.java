import org.junit.Assert;
import org.junit.Test;

public class DiagonalDescendingSearchTest {

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
                {'K','A','A','A'},
                {'A','I','A','A'},
                {'A','A','R','A'},
                {'A','A','A','K'}
        };
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("KIRK");

        assertEquals(solution, "KIRK", expectedPosition);
    }

    @Test
    public void ignoreLeadingPartialMatches() {
        char[][] grid = {
                {'K','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','K','A','A','A'},
                {'A','A','A','I','A','A'},
                {'A','A','A','A','R','A'},
                {'A','A','A','A','A','K'}
        };
        Point[] expectedPosition = {
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),
                new Point(5, 5)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("KIRK");

        assertEquals(solution, "KIRK", expectedPosition);
    }

    @Test
    public void ignoreLeadingPartialMatchesEdgeCase() {
        char[][] grid = {
                {'K','A','A','A','A'},
                {'A','K','A','A','A'},
                {'A','A','I','A','A'},
                {'A','A','A','R','A'},
                {'A','A','A','A','K'}
        };
        Point[] expectedPosition = {
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("KIRK");

        assertEquals(solution, "KIRK", expectedPosition);
    }

    @Test
    public void ignoreTrailingPartialMatches() {
        char[][] grid = {
                {'K','A','A','A','A'},
                {'A','I','A','A','A'},
                {'A','A','R','A','A'},
                {'A','A','A','K','A'},
                {'A','A','A','A','A'}
        };
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("KIRK");

        assertEquals(solution, "KIRK", expectedPosition);
    }


}
