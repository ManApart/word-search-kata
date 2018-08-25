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
        String points = "";
        for (Point p : position){
            points += "(" + p.getX() + "," + p.getY() + "),";
        }
        points = points.substring(0, points.length()-1);
        return name +": " + points;
    }
}
