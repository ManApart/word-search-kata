import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void pointReturnsProperXandY(){
        Point p = new Point(1, 1);
        Assert.assertEquals(1, p.getX());
        Assert.assertEquals(1, p.getY());
    }

    @Test
    public void pointReturnsProperXandYForADifferentValue(){
        Point p = new Point(2, 3);
        Assert.assertEquals(2, p.getX());
        Assert.assertEquals(3, p.getY());
    }

    @Test
    public void pointDoesNotEqualIfValuesDifferent(){
        Point p = new Point(3, 3);
        Point other = new Point(2, 3);
        Assert.assertFalse(p.equals(other));
    }

}
