import java.util.Scanner;

public class Skyscraper {
    private int boardDim;
    private int height;
    private boolean verify = true;
    private int[][] board;
    private int[] checkVal;
    private int valueToCheck;

    public boolean verifyPlacement(int[][] board) {
        outerLoop:
        for (int i = 0; i < board.length; ++i) {

            // Create a new array to check the i row
            checkVal = board[i];
            for (int j = 0; j < board.length; ++j) {

                // Assign valueToCheck to compare against all other ints after it in checkVal
                valueToCheck = checkVal[j];
                for (int k = j + 1; k < board.length; ++k) {

                    // IF an int in checkVal is the same as valueToCheck, break
                    // Set verify to false and return
                    if (valueToCheck == checkVal[k]) {
                        verify = false;
                        break outerLoop;
                    }
                }
            }
        }
        return verify;
    }

    public void loadPuzzle() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the dimension of the board: ");

        // Create the boards dimensions
        boardDim = s.nextInt();
        board = new int[boardDim][boardDim];

        // Fill in the board depending on user input
        for (int i = 0; i < board.length; ++i) {
            System.out.println("Enter the numbers for row " + (int)(i + 1) + ".");
            for (int j = 0; j < board.length; ++j) {
                height = s.nextInt();

                // This IF statement will check if the height is valid [1,board.length]
                // If is not, the skyscraper height will not be set and the user
                // will be asked to enter a appropriate height
                if (height > board.length || height < 1) {
                    System.out.println(height + " is not a valid height.");
                    System.out.print("Valid heights are [1," + board.length + "]: ");
                    --j;
                    continue;
                } else {
                    board[i][j] = height;
                }
            }
        }

    }

    public int[][] getBoard() {
        return board;
    }

    public void print(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; ++j) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public void printWithVisibility(int[][] board) {

    }

    public static void main(String[] args) {
        Skyscraper game = new Skyscraper();

        game.loadPuzzle();
        System.out.println(game.verifyPlacement(game.getBoard()));
        game.print(game.getBoard());
    }

}
