import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void pointReturnsProperXandY(){
        Point p = new Point(1, 1);
        Assert.assertEquals(1, p.getX());
        Assert.assertEquals(1, p.getY());
    }
}
