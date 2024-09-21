import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BigRectLister{
    public static void main(String[] args) {

        BigRectangleFilter filter = new BigRectangleFilter();
        Random random = new Random();


        ArrayList<Rectangle> rectangles = new ArrayList<>();

        for(int i = 0; i<6; i++){
            rectangles.add(new Rectangle(random.nextInt(3) + 1, random.nextInt(2) + 1));
        }
        for(int i = 0; i<6; i++){
            rectangles.add(new Rectangle(random.nextInt(3,15) + 1, random.nextInt(2,15) + 1));
        }

        System.out.println("Below are the rectangle measurement and perimeter of those that have a perimeter greater than 10:");
        for(Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                System.out.println(rect);
                System.out.println(filter.getFilter(rect));
            }
        }


    }
}
