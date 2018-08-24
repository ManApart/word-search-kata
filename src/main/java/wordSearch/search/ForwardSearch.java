package wordSearch.search;

import wordSearch.Point;

import java.util.ArrayList;
import java.util.List;

public class ForwardSearch implements Search {
    private String name;
    private List<Point> position = new ArrayList<>();
    private PositionFinder positionFinder;
    private PositionFinder reversePositionFinder;

    public ForwardSearch(String name) {
        this.name = name;
        positionFinder = new PositionFinder(name);
        reversePositionFinder = new PositionFinder(name, true);
    }

    @Override
    public void examine(char character, int x, int y) {
        if (!isWordFound()) {
            List<Point> possible = positionFinder.examine(character, x, y, 0);
            if (possible != null){
                position = possible;
            } else {
                possible = reversePositionFinder.examine(character, x, y, 0);
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
