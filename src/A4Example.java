/**
 * file: A4Example.java
 * Author: Travis Moore (mooret12)
 * Date: April 12th, 2021
 * Description: Runs the game 
 */

package src;

import java.util.Arrays;

public class A4Example
{
   public static void main(String[] args) {

        BoardT board = new BoardT();

        UserView view = UserView.getInstance();
        Controller game = Controller.getInstance(board, view);

        game.run2048();

    }

}

