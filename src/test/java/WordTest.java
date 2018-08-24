import org.junit.Assert;
import org.junit.Test;

public class WordTest {

    @Test
    public void wordReturnsItsName() {
        Point[] position = {new Point(0,0)};
        Word word = new Word("BONES", position);
        Assert.assertEquals("BONES", word.getName());
    }

    @Test
    public void aDifferentWordReturnsItsName() {
        Point[] position = {new Point(0,0)};
        Word word = new Word("SPOCK", position);
        Assert.assertEquals("SPOCK", word.getName());
    }

    @Test
    public void wordReturnsItsPosition() {
        Point[] position = {
                new Point(0,0),
                new Point(1,0),
                new Point(2,0),
                new Point(3,0),
                new Point(4,0)
        };
        Word word = new Word("SPOCK", position);
        for (int i=0; i< position.length; i++){
            Assert.assertEquals(position[i], word.getPosition()[i]);
        }
    }

}
