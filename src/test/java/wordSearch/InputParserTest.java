package wordSearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;

public class InputParserTest {

    private List<String> input = Arrays.asList(
            "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA",
            "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E",
            "L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G",
            "H,S,U,P,J,P,R,J,D,H,S,B,X,T,G",
            "B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E",
            "A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D",
            "S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F",
            "B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z",
            "O,K,R,I,K,A,M,M,R,M,F,B,A,P,P",
            "N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S",
            "E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K",
            "S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D",
            "T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K",
            "O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H",
            "W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S",
            "K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B"
    );

    @Test
    public void parseSearchWords() {
        InputParser parser = new InputParser(input);
        String[] searchWords = parser.getSearchWords();
        Assert.assertEquals(7, searchWords.length);
        Assert.assertEquals("BONES", searchWords[0]);
        Assert.assertEquals("UHURA", searchWords[6]);
    }

    @Test
    public void parseGrid() {
        InputParser parser = new InputParser(input);
        char[][] grid = parser.getGrid();
        Assert.assertEquals(15, grid.length);
        Assert.assertEquals(15, grid[0].length);
        Assert.assertEquals('U', grid[0][0]);
        Assert.assertEquals('E', grid[0][14]);
        Assert.assertEquals('K', grid[14][0]);
        Assert.assertEquals('B', grid[14][14]);
    }

    @Test
    public void nonSquareFatGridThrowsInvalidGridError() {
        List<String> input = Arrays.asList(
                "AA,AB",
                "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E",
                "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E"
        );

        try {
            InputParser parser = new InputParser(input);
            parser.getGrid();
            fail("Input grid is invalid");
        } catch (InvalidInputException exception) {
            Assert.assertEquals("Grid not square. Row 0 too long.", exception.getMessage());
        }
    }

    @Test
    public void gridThrowsErrorIfLineOverlyLong() {
        List<String> input = Arrays.asList(
                "AA,AB",
                "A,B,C",
                "A,B,C,D",
                "A,B,C"
        );

        try {
            InputParser parser = new InputParser(input);
            parser.getGrid();
            fail("Input grid is invalid");
        } catch (InvalidInputException exception) {
            Assert.assertEquals("Grid not square. Row 1 too long.", exception.getMessage());
        }
    }

    @Test
    public void nonSquareTallGridThrowsInvalidGridError() {
        List<String> input = Arrays.asList(
                "KHAN",
                "U,M",
                "U,M",
                "U,M",
                "U,M"
        );

        try {
            InputParser parser = new InputParser(input);
            parser.getGrid();
            fail("Input grid is invalid");
        } catch (InvalidInputException exception) {
            Assert.assertEquals("Grid not square. Row 0 too short.", exception.getMessage());
        }
    }

    @Test
    public void gridThrowsErrorIfLineOverlyShort() {
        List<String> input = Arrays.asList(
                "AB",
                "A,B,C",
                "A,B,C",
                "A,B"
        );

        try {
            InputParser parser = new InputParser(input);
            parser.getGrid();
            fail("Input grid is invalid");
        } catch (InvalidInputException exception) {
            Assert.assertEquals("Grid not square. Row 2 too short.", exception.getMessage());
        }
    }

    @Test
    public void parserOnlyAcceptsCapitalLetters() {
        List<String> letters = Arrays.asList("1", "a", "#", "!");
        List<Integer> xPositions = Arrays.asList(0, 1, 2, 0);
        List<Integer> yPositions = Arrays.asList(2, 1, 0, 2);

        for (int i = 0; i < letters.size(); i++) {
            List<String> input = createGrid(letters.get(i), xPositions.get(i), yPositions.get(i));
            try {
                InputParser parser = new InputParser(input);
                parser.getGrid();
                fail("Input grid is invalid");
            } catch (InvalidInputException exception) {
                Assert.assertEquals("Row "+ yPositions.get(i) + " contains an invalid character.", exception.getMessage());
            }
        }
    }

    private List<String> createGrid(String letter, int x, int y) {
        List<String> grid = Arrays.asList(
                "AB",
                "A,B,C",
                "A,B,C",
                "A,B,C"
        );
        String[] row = grid.get(y + 1).split(",");
        row[x] = letter;
        String replacement = String.join(",", row);
        grid.set(y + 1, replacement);
        return grid;
    }

    @Test
    public void wordsMustBeAtLeastTwoCharactersLong(){
        List<String> input = Arrays.asList(
                "UM,AB,A",
                "U,M",
                "U,M"
        );

        try {
            InputParser parser = new InputParser(input);
            parser.getGrid();
            fail("Input grid is invalid");
        } catch (InvalidInputException exception) {
            Assert.assertEquals("Input word A is too short.", exception.getMessage());
        }
    }
    @Test
    public void wordsMustBeShorterThanGridSize(){
        List<String> input = Arrays.asList(
                "AB,KHAN,BONES",
                "A,B,C,D",
                "A,B,C,D",
                "A,B,C,D",
                "A,B,C,D"
        );

        try {
            InputParser parser = new InputParser(input);
            parser.getGrid();
            fail("Input grid is invalid");
        } catch (InvalidInputException exception) {
            Assert.assertEquals("Input word BONES is too long.", exception.getMessage());
        }
    }

}
