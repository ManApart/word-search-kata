import org.junit.Assert;
import org.junit.Test;

public class WordTest {

    @Test
    public void wordReturnsItsName() {
        Word word = new Word("BONES");
        Assert.assertEquals("BONES", word.getName());
    }

    @Test
    public void aDifferentWordReturnsItsName() {
        Word word = new Word("SPOCK");
        Assert.assertEquals("SPOCK", word.getName());
    }

}
