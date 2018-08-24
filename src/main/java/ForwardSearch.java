import java.util.ArrayList;
import java.util.List;

public class ForwardSearch implements Search {
    private String name;
    private List<Point> position = new ArrayList<>();
    private int i = 0;

    public ForwardSearch(String name) {
        this.name = name;
    }

    @Override
    public void examine(char character, int x, int y) {
        if (!isWordFound()) {
            if (character == name.charAt(i)) {
                position.add(new Point(x, y));
                i++;
            } else if (character == name.charAt(0)) {
                position.clear();
                position.add(new Point(x, y));
                i = 1;
            } else {
                position.clear();
                i = 0;
            }
        }
    }

    @Override
    public boolean isWordFound() {
        return position.size() == name.length();
    }

    @Override
    public List<Point> getPosition() {
        return position;
    }
}
