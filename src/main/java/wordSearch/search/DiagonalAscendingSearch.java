package wordSearch.search;

import wordSearch.Point;

import java.util.ArrayList;
import java.util.List;

public class DiagonalAscendingSearch implements Search {
    private String name;
    private List<Point> position = new ArrayList<>();
    private PositionFinder positionFinder;

    public DiagonalAscendingSearch(String name) {
        this.name = name;
        positionFinder = new PositionFinder(name, true);
    }

    @Override
    public void examine(char character, int x, int y) {
        if (!isWordFound()) {
            int originalX = -x-y;
            List<Point> possible = positionFinder.examine(character, x, y, originalX);
            if (possible != null){
                position = possible;
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
