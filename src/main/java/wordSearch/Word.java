package wordSearch;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Word {
    private String name;
    private Point[] position;

    Word(String name, Point[] position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Point[] getPosition() {
        return position;
    }

    String getPrintOut() {
        String points = Arrays.stream(position)
                .map(Point::getPrintOut)
                .collect(Collectors.joining(","));

        return name + ": " + points;
    }
}
