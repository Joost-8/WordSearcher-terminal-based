import java.util.Scanner;


public class GuessingWords {
    
    public void guessingInput(Grid grid) {
        Scanner sc = new Scanner(System.in);
        String[] wordsList = grid.wordsList();
        boolean[] found = new boolean[wordsList.length];
        grid.printGrid();

        while (true) {
            System.out.print("Enter a word you found: ");
            String guess = sc.next().toUpperCase();

            boolean valid = false;
            for (int i = 0; i < wordsList.length; i++) {
                if (guess.equals(wordsList[i]) && !found[i]) {
                    found[i] = true;
                    valid = true;
                    grid.printGrid();
                    System.out.println("Correct! You found " + guess);
                    break;
                }
            }

            if (!valid) {
                grid.printGrid();
                System.out.println("Not a valid word or already found.");
            }

            // Check if all words are found
            boolean allFound = true;
            for (boolean b : found) {
                if (!b) allFound = false;
            }
            if (allFound) {
                System.out.println("Congratulations! You found all the words!");
                break;
            }
        }  
    }


    public static void main(String[] args) {
        DifficultyChooser d = new DifficultyChooser();
        
        int[] difficulty = d.initialInputReader();


        Grid grid = new Grid(difficulty);

        grid.wordListToGrid(grid.wordsList());

        grid.randomizeLetters();

        GuessingWords guessing = new GuessingWords();

        guessing.guessingInput(grid);

    }




}
