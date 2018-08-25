package wordSearch;

import org.junit.Assert;
import org.junit.Test;

public class WordTest {

    @Test
    public void wordReturnsItsName() {
        Point[] position = {new Point(0, 0)};
        Word word = new Word("BONES", position);
        Assert.assertEquals("BONES", word.getName());
    }

    @Test
    public void aDifferentWordReturnsItsName() {
        Point[] position = {new Point(0, 0)};
        Word word = new Word("SPOCK", position);
        Assert.assertEquals("SPOCK", word.getName());
    }

    @Test
    public void wordReturnsItsPosition() {
        Point[] position = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        };
        Word word = new Word("SPOCK", position);
        for (int i = 0; i < position.length; i++) {
            Assert.assertEquals(position[i], word.getPosition()[i]);
        }
    }

    @Test
    public void printWord() {
        Point[] position = {
                new Point(0, 6),
                new Point(0, 7),
                new Point(0, 8),
                new Point(0, 9),
                new Point(0, 10)
        };
        Word word = new Word("BONES", position);
        Assert.assertEquals("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)", word.getPrintOut());
    }

    @Test
    public void printADifferentWord() {
        Point[] position = {
                new Point(5, 9),
                new Point(5, 8),
                new Point(5, 7),
                new Point(5, 6)
        };
        Word word = new Word("KHAN", position);
        Assert.assertEquals("KHAN: (5,9),(5,8),(5,7),(5,6)", word.getPrintOut());
    }

}
