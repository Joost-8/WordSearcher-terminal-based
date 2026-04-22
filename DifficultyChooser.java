
import java.util.Scanner;


public class DifficultyChooser {
  
  public int[] initialInputReader() {
    Scanner sc = new Scanner(System.in);
    String difficulty = "";
    int[] result = null;

  while (result == null) {
    System.out.println("Choose your difficulty by typing \"easy\", \"medium\" or \"hard\": ");
      difficulty = sc.next();

      switch (difficulty.toLowerCase()) {
        case "easy":
          result = new int[] {8, 8, 5};
          break;
        case "medium":
          result = new int[] {12, 12, 10};
          break;
        case "hard":
          result = new int[] {16, 16, 15};
          break;
        default:
          System.out.println("Invalid input. Please type easy, medium, or hard.");
          break;
      }
  }

       return result;

  

    }
}