import java.awt.Rectangle;
public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rec = (Rectangle) x;
            return 2 * (rec.width + rec.height) > 10;
        }
        return false;
    }
}