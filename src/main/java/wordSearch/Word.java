package wordSearch;

public class Word {
    private String name;
    private Point[] position;

    public Word(String name, Point[] position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Point[] getPosition() {
        return position;
    }

    public String getPrintOut() {
        return "BONES: (0,6),(0,7),(0,8),(0,9),(0,10)";
    }
}
