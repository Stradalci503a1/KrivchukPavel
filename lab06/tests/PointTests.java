import org.junit.Assert;
import org.junit.Test;

public class PointTests {

    @Test
    public void pointsNotInOneLine(){
        Point firstPoint = new Point(1, 3, 4);
        Point secondPoint = new Point(2, -7, 7);
        Point thirdPoint = new Point(-4, -14, 1);
        Assert.assertFalse(Point.isOneStraightLine(firstPoint, secondPoint, thirdPoint));
    }

    @Test
    public void pointsNotInOnePlane(){
        Point firstPoint = new Point(5,3,1);
        Point secondPoint = new Point(-3,2,3);
        Point thirdPoint = new Point(3,8,6);
        Point fourthPoint = new Point(-3,1,2);
        Assert.assertFalse(Point.isOnePlane(firstPoint, secondPoint, thirdPoint, fourthPoint));
    }

    @Test
    public void distanceBetweenPoints(){
        Point firstPoint = new Point(1, 3, 2);
        Point secondPoint = new Point(5, -1, 4);
        Assert.assertEquals(6.0, firstPoint.distanceTo(secondPoint), 0);
    }

    @Test
    public void pointsInOneLine(){
        Point firstPoint = new Point(1, 8);
        Point secondPoint = new Point(-2, -7);
        Point thirdPoint = new Point(-4, -17);
        Assert.assertTrue(Point.isOneStraightLine(firstPoint, secondPoint, thirdPoint));
    }

    @Test
    public void pointsInOnePlane(){
        Point firstPoint = new Point(1,-2,2);
        Point secondPoint = new Point(1,4,0);
        Point thirdPoint = new Point(-4,1,1);
        Point fourthPoint = new Point(-5,-5,3);
        Assert.assertTrue(Point.isOnePlane(firstPoint, secondPoint, thirdPoint, fourthPoint));
    }
}
