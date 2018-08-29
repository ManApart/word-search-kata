package wordSearch.search;

import wordSearch.Point;

import java.util.ArrayList;
import java.util.List;

public class DiagonalAscendingSearch implements Search {
    private String name;
    private List<Point> position = new ArrayList<>();
    private WordPositionFinder wordPositionFinder;
    private WordPositionFinder reverseWordPositionFinder;

    public DiagonalAscendingSearch(String name) {
        this.name = name;
        wordPositionFinder = new WordPositionFinder(name);
        reverseWordPositionFinder = new WordPositionFinder(name, true);
    }

    @Override
    public void examine(char character, int x, int y) {
        if (!isWordFound()) {
            int originalX = -x-y;
            List<Point> possible = wordPositionFinder.examine(character, x, y, originalX);
            if (possible != null){
                position = possible;
            } else {
                possible = reverseWordPositionFinder.examine(character, x, y, originalX);
                if (possible != null) {
                    position = possible;
                }
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
