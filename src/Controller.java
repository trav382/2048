/**
 * file Controller.java
 * Author: Travis Moore (mooret12)
 * Date: April 12, 2021
 * 
 * Description: Class for Controller that will handle input from 
 *  terminal and connects UserView and BoardT
 */

package src;

import java.util.Scanner;

public class Controller{


    private BoardT model;
    private UserView view;
    private static Controller controller = null;

    private Scanner scanner = new Scanner(System.in);


    /**
     * @brief Constructor
     * @param model - BoardT object
     * @param view -  UserView object
     */
    private Controller(BoardT model, UserView view){
        this.model = model;
        this.view = view;
    }

    /**
     * @brief method for getting a single instance
     * @return a single Controller object
     */
    public static Controller getInstance(BoardT model, UserView view){ 
     
        if (controller == null) 
            controller = new Controller(model, view); 
  
        return controller; 
    } 

    /**
     * @brief initializes the game
     */
    public void initializeGame(){

        this.model = new BoardT();
    }

    /**
     * @brief updates the view module to show a welcome message to window/terminal
     */
    public void showWelcomeMessage(){

        view.printWelcomeMessage();
    }

    /**
     * @brief updates the view module to show a end of game message
     */
    public void showEndMessage(){


        view.printEndingMessage(model);
    }

    /**
     * @brief updates the view module to show the board
     */
    public void showBoard(){

        view.printBoard(model);
    }

    /**
     * @brief runs 2048.
     */
    public void run2048(){

        String move;

        initializeGame();
        
        view.printBoard2(model);
        

        while (true){

            move = scanner.next();
            

            if (move.equals("w")){

                model.moveUp();
                showBoard();

                if (model.gameOver()){

                    break;
                }
            }

            else if (move.equals("s")){

                model.moveDown();
                showBoard();
                if (model.gameOver()){

                    break;
                }

            }

            else if (move.equals("a")){

                model.moveLeft();
                showBoard();
                if (model.gameOver()){

                    break;
                }

            }

            else if (move.equals("d")){

                model.moveRight();
                showBoard();
                if (model.gameOver()){

                    break;
                }

            }

            else if (move.equals("p")){

                System.exit(1);

            } 
            else{
                System.out.println("Please enter valid input");
            }


        }
        view.printBoard2(model);
        showEndMessage();
    }

}