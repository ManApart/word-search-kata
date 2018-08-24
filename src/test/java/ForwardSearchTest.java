import org.junit.Assert;
import org.junit.Test;

public class ForwardSearchTest {

    private void assertEquals(Word solution, String name, Point[] position){
        Assert.assertEquals(name, solution.getName());

        Assert.assertEquals(position.length, solution.getPosition().length);
        for (int i = 0; i < position.length; i++) {
            Assert.assertTrue(position[i].equals(solution.getPosition()[i]));
        }
    }


    @Test
    public void simplestPossible() {
        char[][] grid = {{'B', 'O', 'N', 'E', 'S'}};
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("BONES");

        assertEquals(solution, "BONES", expectedPosition);
    }

    @Test
    public void simplestPossibleWithDifferentName() {
        char[][] grid = {{'S', 'P', 'O', 'C', 'K'}};
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SPOCK");

        assertEquals(solution, "SPOCK", expectedPosition);
    }

    @Test
    public void endOfLargerLine() {
        char[][] grid = {{'I', 'L', 'I', 'K', 'E', 'S', 'P', 'O', 'C', 'K'}};
        Point[] expectedPosition = {
                new Point(5, 0),
                new Point(6, 0),
                new Point(7, 0),
                new Point(8, 0),
                new Point(9, 0)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SPOCK");

        assertEquals(solution, "SPOCK", expectedPosition);
    }

    @Test
    public void startOfLargerLine() {
        char[][] grid = {{'S', 'P', 'O', 'C', 'K','I','S','C','O','O','L'}};
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SPOCK");

        assertEquals(solution, "SPOCK", expectedPosition);
    }

    @Test
    public void singleMatchingLetterBeforeWord() {
        char[][] grid = {{'I', 'S', 'E', 'E', 'S', 'P', 'O', 'C', 'K'}};
        Point[] expectedPosition = {
                new Point(4, 0),
                new Point(5, 0),
                new Point(6, 0),
                new Point(7, 0),
                new Point(8, 0)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SPOCK");

        assertEquals(solution, "SPOCK", expectedPosition);
    }

    @Test
    public void matchOnSecondRow() {
        char[][] grid = {
                {'A', 'A', 'A', 'A', 'A'},
                {'S', 'P', 'O', 'C', 'K'},
                {'A', 'A', 'A', 'A', 'A'}
        };
        Point[] expectedPosition = {
                new Point(0, 1),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1),
                new Point(4, 1)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SPOCK");

        assertEquals(solution, "SPOCK", expectedPosition);
    }

    @Test
    public void dontErrorOnWrapAround() {
        char[][] grid = {
                {'B', 'O', 'N', 'E', 'S'},
                {'S', 'P', 'O', 'C', 'K'},
                {'A', 'A', 'A', 'A', 'A'}
        };
        Point[] expectedPosition = {
                new Point(0, 1),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1),
                new Point(4, 1)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("SPOCK");

        assertEquals(solution, "SPOCK", expectedPosition);
    }

}
