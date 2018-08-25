package wordSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.lines(Paths.get(args[0])).collect(Collectors.toList());
        InputParser parser = new InputParser(lines);
        String[] words = parser.getSearchWords();
        PuzzleSolver solver = new PuzzleSolver(parser.getGrid());
        for (String wordString : words) {
            Word word = solver.find(wordString);
            System.out.println(word.getPrintOut());
        }
    }
}
