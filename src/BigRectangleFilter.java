import java.awt.Rectangle;
public class BigRectangleFilter implements Filter{

    public double getFilter(Object x)
    {
        Rectangle r = (Rectangle) x;
        return (2 * r.height) + (2 * r.width);
    }

    @Override
    public boolean accept(Object x) {
        Rectangle r = (Rectangle) x;
       double perimeter =  (2 * r.height) + (2 * r.width);
       return perimeter > 10;
    }
}
