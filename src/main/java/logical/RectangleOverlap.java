package logical;

public class RectangleOverlap {


    static class Point {
        int x, y;
    }

    static boolean isRectanglesOverlapped(Point l1, Point r1, Point l2, Point r2) {
        // Checks one is left / right side of other
        if (r1.x < l2.x || l1.x > r2.x) {
            return false;
        }
        // Checks one top/ bottom of other
        if (l1.y < r2.y || r1.y > l2.y) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Point l1 = new Point(),r1 = new Point(),
                l2 = new Point(),r2 = new Point();
        l1.x=0;l1.y=10; r1.x=10;r1.y=0;
        l2.x=5;l2.y=5; r2.x=15;r2.y=0;

        System.out.println("Rectangles Overlapped - "+isRectanglesOverlapped(l1, r1, l2, r2));

        l1.x=1;l1.y=4; r1.x=3;r1.y=2;
        l2.x=5;l2.y=4; r2.x=7;r2.y=2;
        System.out.println("Rectangles Overlapped - "+isRectanglesOverlapped(l1, r1, l2, r2));
    }
}
