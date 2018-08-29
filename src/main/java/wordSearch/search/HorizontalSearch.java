package wordSearch.search;

import wordSearch.Point;

import java.util.ArrayList;
import java.util.List;

public class HorizontalSearch implements Search {
    private String word;
    private List<Point> position = new ArrayList<>();
    private WordPositionFinder wordPositionFinder;
    private WordPositionFinder reverseWordPositionFinder;

    public HorizontalSearch(String word) {
        this.word = word;
        wordPositionFinder = new WordPositionFinder(word);
        reverseWordPositionFinder = new WordPositionFinder(word, true);
    }

    @Override
    public void examine(char character, int x, int y) {
        if (!isWordFound()) {
            List<Point> possible = wordPositionFinder.examine(character, x, y, 0);
            if (possible != null){
                position = possible;
            } else {
                possible = reverseWordPositionFinder.examine(character, x, y, 0);
                if (possible != null) {
                    position = possible;
                }
            }
        }
    }

    @Override
    public boolean isWordFound() {
        return position.size() == word.length();
    }

    @Override
    public List<Point> getPosition() {
        return position;
    }
}
