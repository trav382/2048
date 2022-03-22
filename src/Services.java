/**
 * file: Services.java  
 * Author: Travis Moore (mooret12)
 * Date: April 12, 2021
 * 
 * Description: Services module containing functions to help with BoardT
 */

package src;

/**
 * This class contains functions to help create tiles in BoardT. They both deal with using Math.random()
 */
public class Services{

    /**
     * @brief Randomly generates a index for a new tile.
     *
     * @return  Integer between 0-3.
     */
    public static int newCellLocation(){

        double num = Math.random();
        if (num < 0.25){

            return 0;

        } else if (num < 0.5) {

            return 1;

        }else if (num < 0.75) {

            return 2;
        }else {

            return 3;
        }   
    } 
    /**
     * @brief Uses random number from 0 to 1 to decide the new tile's value.
     *
     * @return     either 2 or 4.
     */
    public static int newTileNumber(){

        if (Math.random() < 0.9){

            return 2;
        } else{
            return 4;
        }
    } 






}