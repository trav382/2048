/**
 * file UserView.java
 * Author: Travis Moore (mooret12)
 * Date: April 12, 2021
 * 
 * Description: Class for view that deals with outputting information
 * to the terminal/window.
 *  
 */

package src;

/**
 * This class is for outputting the game to the terminal/window.
 */
public class UserView{


    private static UserView visual = null;

   /**
    * @brief Constructor.
    */
    private UserView(){}

   /**
    * @brief method for getting a single instance
    * @return an UserView object
    */
    public static UserView getInstance(){

        if (visual == null){

            return visual = new UserView();
        }
        return visual;
    }


   /**
    * @brief Displays a welcome message.
    */
    public void printWelcomeMessage(){

        System.out.println("-------------------------------------------------");
        System.out.println("                 Welcome To 2048                ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
    }

   /**
    * @brief Displays a end of game message. Also displays final score.
    * @param board - A boardT object.
    */
    public void printEndingMessage(BoardT board){

        System.out.println("-------------------------------------------------");
        System.out.println("             Game Over.                          ");
        System.out.printf("             Final Score: " + board.getScore()      );
        System.out.println();
        System.out.println("-------------------------------------------------");
    }


   /**
    * @brief Displays the current state of the game board. Also clears terminal before displaying
    *  the board. This allows for smooth transition between moves.
    * @param board - A boardT object.
    */
    public void printBoard(BoardT board){

        int size = board.size;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        printWelcomeMessage();
        System.out.println();
        System.out.printf("Score: " +  board.getScore());
        System.out.println();
        System.out.println();

        for (int i = 0; i < size; i++){

            for (int j = 0; j < size; j++){

                // System.out.print(board.board[i][j] + "  ");
                if (j == size-1){

                    if (board.getCell(i,j) != 0){

                        System.out.print(String.format("%-4s%-4d|", "|", board.getCell(i,j)));

                    } else {
                        System.out.print(String.format("%-4s%-4s|", "|", ""));
                    }
                    
                } else {

                        if (board.getCell(i,j) != 0){

                            System.out.print(String.format("%-4s%-4d ", "|", board.getCell(i,j)));

                    }   else {
                            System.out.print(String.format("%-4s%-4s ", "|", ""));
                    }
            }
            }
                
                System.out.println();
            
        }

        System.out.println();
    }

       /**
        * @brief Displays the current state of the game board. Does NOT clear terminal before displaying
        *  the board. This is needed for the end of the game, so the final board with the final tile will
        *  be displayed.
        * @param board - A boardT object.
        */
        public void printBoard2(BoardT board){

        printWelcomeMessage();

        int size = board.size;
        System.out.println();
        System.out.printf("Score: " +  board.getScore());
        System.out.println();
        System.out.println();
        for (int i = 0; i < size; i++){

            for (int j = 0; j < size; j++){

    
                if (j == size-1){

                    if (board.getCell(i,j) != 0){

                        System.out.print(String.format("%-4s%-4d|", "|", board.getCell(i,j)));

                    } else {
                        System.out.print(String.format("%-4s%-4s|", "|", ""));
                    }
                    
                } else {

                        if (board.getCell(i,j) != 0){

                            System.out.print(String.format("%-4s%-4d ", "|", board.getCell(i,j)));

                    }   else {
                            System.out.print(String.format("%-4s%-4s ", "|", ""));
                    }
            }
            }
                
                System.out.println();
            
        }

        System.out.println();
    }

}