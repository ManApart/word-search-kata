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
}
