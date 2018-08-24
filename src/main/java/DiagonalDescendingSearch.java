import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiagonalDescendingSearch implements Search {
    private String name;
    private HashMap<Integer, List<Point>> positions = new HashMap<>();
    private HashMap<Integer, Integer> indexes = new HashMap<>();
    private List<Point> position = new ArrayList<>();

    public DiagonalDescendingSearch(String name) {
        this.name = name;
    }

    @Override
    public void examine(char character, int x, int y) {
        int originalX = x - y;
        int i = getIndex(originalX);
        List<Point> position = getColumnPosition(originalX);
        if (character == name.charAt(i)) {
            position.add(new Point(x, y));
            if (position.size() == name.length()) {
                this.position = position;
            } else {
                positions.put(originalX, position);
                indexes.put(originalX, i + 1);
            }
        } else if (character == name.charAt(0)) {
            position.clear();
            position.add(new Point(x, y));
            positions.put(originalX, position);
            indexes.put(originalX, 1);
        } else {
            position.clear();
            positions.put(originalX, position);
            indexes.put(originalX, 0);
        }
    }

    private int getIndex(int column) {
        if (indexes.containsKey(column)) {
            return indexes.get(column);
        }
        return 0;
    }

    private List<Point> getColumnPosition(int column) {
        if (positions.containsKey(column)) {
            return positions.get(column);
        }
        return new ArrayList<>();
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
