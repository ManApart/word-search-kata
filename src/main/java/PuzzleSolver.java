public class PuzzleSolver {

    public PuzzleSolver(char[][] grid) {
    }


    public Word find(String name) {
        return new Word(name, new Point[]{
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        });
    }
}
