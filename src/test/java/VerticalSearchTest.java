import org.junit.Assert;
import org.junit.Test;

public class VerticalSearchTest {

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
                {'B'},
                {'O'},
                {'N'},
                {'E'},
                {'S'}
        };
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 3),
                new Point(0, 4)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("BONES");

        assertEquals(solution, "BONES", expectedPosition);
    }

    @Test
    public void withinLargerLine() {
        char[][] grid = {
                {'M'},
                {'Y'},
                {'O'},
                {'L'},
                {'D'},
                {'B'},
                {'O'},
                {'N'},
                {'E'},
                {'S'}
        };
        Point[] expectedPosition = {
                new Point(0, 5),
                new Point(0, 6),
                new Point(0, 7),
                new Point(0, 8),
                new Point(0, 9)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("BONES");

        assertEquals(solution, "BONES", expectedPosition);
    }

    @Test
    public void longerLineStartsWithWord() {
        char[][] grid = {
                {'B'},
                {'O'},
                {'N'},
                {'E'},
                {'S'},
                {'H'},
                {'E'},
                {'R'},
                {'E'}
        };
        Point[] expectedPosition = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 3),
                new Point(0, 4)
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        Word solution = solver.find("BONES");

        assertEquals(solution, "BONES", expectedPosition);
    }

}
