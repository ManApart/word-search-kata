package wordSearch.search;

import wordSearch.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class WordPositionFinder {
    private String word;
    private boolean reverse;
    private HashMap<Integer, List<Point>> positions = new HashMap<>();
    private HashMap<Integer, Integer> indexes = new HashMap<>();
    private char firstCharacter;

    WordPositionFinder(String word) {
        this(word, false);
    }

    WordPositionFinder(String word, boolean reverse) {
        this.word = word;
        this.reverse = reverse;

        if (reverse) {
            firstCharacter = word.charAt(word.length() - 1);
        } else {
            firstCharacter = word.charAt(0);
        }
    }

    List<Point> examine(char character, int x, int y, int start) {
        int i = getIndex(start);
        List<Point> position = getColumnPosition(start);
        char current = getCurrentChar(i);

        if (character == current) {
            return addCharacter(x, y, start, i, position);
        } else if (character == firstCharacter) {
            restartSearchFromHere(x, y, start, position);
        } else {
            restartSearchFromBeginning(start, position);
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

    private char getCurrentChar(int i) {
        if (reverse) {
            return word.charAt(word.length() - (i + 1));
        } else {
            return word.charAt(i);
        }
    }

    private List<Point> addCharacter(int x, int y, int start, int i, List<Point> position) {
        position.add(new Point(x, y));
        if (position.size() == word.length()) {
            return getPosition(position);
        } else {
            positions.put(start, position);
            indexes.put(start, i + 1);
            return null;
        }
    }

    private List<Point> getPosition(List<Point> position) {
        if (reverse) {
            Collections.reverse(position);
            return position;
        } else {
            return position;
        }
    }

    private void restartSearchFromHere(int x, int y, int start, List<Point> position) {
        position.clear();
        position.add(new Point(x, y));
        positions.put(start, position);
        indexes.put(start, 1);
    }

    private void restartSearchFromBeginning(int start, List<Point> position) {
        position.clear();
        positions.put(start, position);
        indexes.put(start, 0);
    }

}
