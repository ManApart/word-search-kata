import java.util.List;

public interface Search {
    void examine(char character, int x, int y);
    boolean isWordFound();
    List<Point> getPosition();
}
