import org.junit.Assert;
import org.junit.Test;

public class ForwardSearchTest {

    @Test
    public void simplestPossibleForwardSearch() {
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

        Assert.assertEquals("BONES", solution.getName());

        Assert.assertEquals(expectedPosition.length, solution.getPosition().length);
        for (int i=0; i< expectedPosition.length; i++){
            Assert.assertTrue(expectedPosition[i].equals(solution.getPosition()[i]));
        }
    }

    @Test
    public void simplestPossibleForwardSearchWithDifferentName() {
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

        Assert.assertEquals("SPOCK", solution.getName());

        Assert.assertEquals(expectedPosition.length, solution.getPosition().length);
        for (int i=0; i< expectedPosition.length; i++){
            Assert.assertTrue(expectedPosition[i].equals(solution.getPosition()[i]));
        }
    }

}
