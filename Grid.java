import java.util.Random;

public class Grid {
    private int rows;
    private int cols;
    private int amountOfWords;
    private String[][] grid;

    
    
    
    public Grid (int[] difficulty) {
        this.rows = difficulty[0];
        this.cols = difficulty[1];
        this.amountOfWords = difficulty[2];
        this.grid = new String[rows][cols];
    }

    //getters
    public String getLetter(int row, int col) {
        return grid[row][col];
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getAmountOfWords() {
        return this.amountOfWords;
    }

    public void setLetter(int row, int col, String l) {
        grid[row][col] = l;
    }

    public boolean canSetLetter(int row, int col) {
        if (grid[row][col] == null) {
            return true;
        }
        return false;
    }

    public void horizontalWordSet(String s) {
        Random random = new Random();

        while (true) {
            int rRow = random.nextInt(rows);
            int rCol = random.nextInt(cols);

            if (rCol + s.length() > cols) {
                continue;
            }


            boolean canPlace = true;
            for (int i = 0; i < s.length(); i++) {
                if (!canSetLetter(rRow, rCol + i)) {
                    canPlace = false;
                    break;
                }
            }

            if (!canPlace) {
                continue;
            }
      
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                String letter = "" + c;

                setLetter(rRow, rCol + i, letter);
            }

            break;

        }

    }

    public void verticalWordSet(String s) {
        Random random = new Random();

        while (true) {
            int rRow = random.nextInt(rows);
            int rCol = random.nextInt(cols);

            if (rRow + s.length() > rows) {
                continue;
            }


            boolean canPlace = true;
            for (int i = 0; i < s.length(); i++) {
                if (!canSetLetter(rRow + i, rCol)) {
                    canPlace = false;
                    break;
                }
            }

            if (!canPlace) {
                continue;
            }
      
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                String letter = "" + c;

                setLetter(rRow + i, rCol, letter);
            }

            break;

        }

    }

    public void diagonalWordSet(String s) {
        Random random = new Random();

        while (true) {
            int rRow = random.nextInt(rows);
            int rCol = random.nextInt(cols);

            if (rRow + s.length() > rows || rCol + s.length() > cols) {
                continue;
            }


            boolean canPlace = true;
            for (int i = 0; i < s.length(); i++) {
                if (!canSetLetter(rRow + i, rCol + i)) {
                    canPlace = false;
                    break;
                }
            }

            if (!canPlace) {
                continue;
            }
      
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                String letter = "" + c;

                setLetter(rRow + i, rCol + i, letter);
            }

            break;

        }

    }

    public String[] wordsList() {

        if (amountOfWords == 5) {
            String[] wordsList = WordBank.WORDS_EASY;
            return wordsList;
        }

        if (amountOfWords == 10) {
            String[] wordsList = WordBank.WORDS_MEDIUM;
            return wordsList;
        }

        if (amountOfWords == 15) {
            String[] wordsList = WordBank.WORDS_HARD;
            return wordsList;
        }

        return WordBank.WORDS_EASY;

    }

    public void wordListToGrid(String[] s) {
        Random r = new Random();
        
        for (String word: s) {
            int rNumber = r.nextInt(3);

            if (rNumber == 0) {
                horizontalWordSet(word);
            }
            else if (rNumber == 1) {
                verticalWordSet(word);
            } else {
                diagonalWordSet(word);
            }
        }
    }

    public void randomizeLetters() {

        Random r = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canSetLetter(i, j)) {
                    int randNumber = r.nextInt(WordBank.WORDS_ALPHABET.length);
                    grid[i][j] = WordBank.WORDS_ALPHABET[randNumber];
                }

            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }    

    






















}