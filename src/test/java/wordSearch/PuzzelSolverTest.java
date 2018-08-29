package wordSearch;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PuzzelSolverTest {

    @Test
    public void throwErrorWhenNoWordFound(){
        char[][] grid = {
            {'S'},
            {'E'},
            {'N'},
            {'O'},
            {'B'}
        };

        PuzzleSolver solver = new PuzzleSolver(grid);
        String word = "STARTREK";

        try {
            solver.find(word);
            fail("Word should not have been found");
        } catch(WordNotFoundException exception) {
            Assert.assertEquals(word + " not found in puzzle.", exception.getMessage());
        }

    }
}
