import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PositionFinder {
    private String name;
    private HashMap<Integer, List<Point>> positions = new HashMap<>();
    private HashMap<Integer, Integer> indexes = new HashMap<>();

    public PositionFinder(String name) {
        this.name = name;
    }

    public List<Point> examine(char character, int x, int y, int start) {
        int i = getIndex(start);
        List<Point> position = getColumnPosition(start);
        if (character == name.charAt(i)) {
            position.add(new Point(x, y));
            if (position.size() == name.length()) {
                return position;
            } else {
                positions.put(start, position);
                indexes.put(start, i + 1);
            }
        } else if (character == name.charAt(0)) {
            position.clear();
            position.add(new Point(x, y));
            positions.put(start, position);
            indexes.put(start, 1);
        } else {
            position.clear();
            positions.put(start, position);
            indexes.put(start, 0);
        }
        return null;
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

}
