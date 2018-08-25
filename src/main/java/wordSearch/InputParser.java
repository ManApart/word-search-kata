package wordSearch;

import java.util.List;

public class InputParser {
    private String[] words;

    public InputParser(List<String> input) {
        this.words = input.get(0).split(",");

    }

    public String[] getSearchWords() {
        return words;
    }
}
