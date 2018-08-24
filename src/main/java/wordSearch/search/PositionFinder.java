package wordSearch.search;

import wordSearch.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PositionFinder {
    private String name;
    private boolean reverse;
    private HashMap<Integer, List<Point>> positions = new HashMap<>();
    private HashMap<Integer, Integer> indexes = new HashMap<>();
    private char firstCharacter;

    public PositionFinder(String name) {
        this(name, false);
    }

    public PositionFinder(String name, boolean reverse) {
        this.name = name;
        this.reverse = reverse;
        if (reverse) {
            firstCharacter = name.charAt(name.length() - 1);
        } else {
            firstCharacter = name.charAt(0);
        }
    }

    public List<Point> examine(char character, int x, int y, int start) {
        int i = getIndex(start);
        List<Point> position = getColumnPosition(start);
        char current = getCurrentChar(i);

        if (character == current) {
            position.add(new Point(x, y));
            if (position.size() == name.length()) {
                if (reverse) {
                    Collections.reverse(position);
                    return position;
                } else {
                    return position;
                }
            } else {
                positions.put(start, position);
                indexes.put(start, i + 1);
            }
        } else if (character == firstCharacter) {
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

    private char getCurrentChar(int i) {
        if (reverse) {
            return name.charAt(name.length() - (i + 1));
        } else {
            return name.charAt(i);
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

}
