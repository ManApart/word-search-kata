package wordSearch;

import java.util.List;

class InputParser {
    private String[] words;
    private char[][] grid;

    InputParser(List<String> input) {
        if (input.isEmpty()){
            throw new InvalidInputException("No data found.");
        }

        this.words = parseWords(input);
        this.grid = parseGrid(input);
    }

    private String[] parseWords(List<String> input) {
        String[] words = input.get(0).split(",");

        int gridSize = input.size()-1;
        validateWords(words, gridSize);
        
        return words;
    }

    private void validateWords(String[] words, int gridSize) {
        for (String word : words){
            if (word.length() < 2){
                throw new InvalidInputException("Input word " + word + " is too short.");
            }
            if (word.length() > gridSize){
                throw new InvalidInputException("Input word " + word + " is too long.");
            }
        }
    }

    private char[][] parseGrid(List<String> input) {
        List<String> gridInput = input.subList(1, input.size());
        String capitalLettersPattern= "^[A-Z]*$";

        char[][] grid = new char[gridInput.size()][gridInput.size()];
        for (int y = 0; y < gridInput.size(); y++) {
            String rowString = gridInput.get(y).replaceAll(",", "");
            if (!rowString.matches(capitalLettersPattern)) {
                throw new InvalidInputException("Row "+ y + " contains an invalid character.");
            }

            char[] row = rowString.toCharArray();
            validateGridIsSquare(gridInput.size(), row.length, y);
            System.arraycopy(row, 0, grid[y], 0, row.length);
        }

        return grid;
    }

    private void validateGridIsSquare(int gridSize, int rowLength, int row) {
        if (rowLength > gridSize) {
            throw new InvalidInputException("Grid not square. Row " + row + " too long.");
        } else if (rowLength < gridSize) {
            throw new InvalidInputException("Grid not square. Row " + row + " too short.");
        }
    }

    String[] getSearchWords() {
        return words;
    }

    char[][] getGrid() {
        return grid;
    }
}
