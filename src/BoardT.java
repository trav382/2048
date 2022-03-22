/**
 * file: BoardT.java  
 * Author: Travis Moore (mooret12)
 * Date: April 12, 2021
 * 
 * Description: module representing the game board/grid.
 */

package src;

public class BoardT{


    private int[][] board;
    private int score;
    public final static int size = 4;

    /**
     * @brief Constructor
     * @details generates a board with two randomly inserted tiles
     */
    public BoardT(){

        this.board = new int[size][size];
        this.score = 0;

        for (int i = 0; i < size; i++){

            for (int j = 0; j < size; j++){

                board[i][j] = 0;
            }
        }
        addTile();
        addTile();
    }

    /**
     * @brief Gets the cell number at given x and y 
     * @param x - row number
     * @param y - column number
     *
     * @return Integer value of cell/tile.
     */
    public int getCell(int x, int y){

        return board[x][y];
    }

    /**
     * @brief the current score for the game.
     * @return Integer representing the score.
     */
    public int getScore(){

        return score;
    }

    /**
     * @brief Sets a tile number at a given x y coordinate. Used for testing.
     * @param x - row number
     * @param y - column number
     * @param number - value of the tile.
     * 
     */
    public void setTile(int x, int y, int number){

        board[x][y] = number;
    }

    /**
     * @brief Adds a tile to the game board. Location and value is random.
     * 
     */
    public void addTile(){

        boolean done = false;

        while (!done){

            int x = Services.newCellLocation();
            int y = Services.newCellLocation();
            int cellValue = Services.newTileNumber();

            if (board[y][x] == 0){

                board[y][x] = cellValue;
                done = true;
            }
        }
    }

    /**
     * @brief Checks to see if game is over or not. Game is over 
     * when you cannot make any more moves and every tile is full (non-zero).
     * @return True if game is over, False if game is not over.
     */
    public boolean gameOver(){

        for (int i = 0; i < size; i++){

            for (int j = 0; j < size-1; j++){


                if (board[i][j] == 0 || board[j][i] == 0){

                    return false;
                }

                if (board[i][j] == board[i][j+1]){

                    return false;
                }  

                if (board[j][i] == board[j+1][i] ){

                    return false;
                }
            }
        }

        return true;
    }
    /**
     * @brief Shifts every number to the right if possible. Also adds
     *  tiles that are next together with the same number. Updates score if this
     *  happens.
     */
    public void moveRight(){

        boolean changed = false;
        int x;
        int y;
        for (int i = 0; i < size; i++){

            boolean check = shiftrowRight(i);
            if (check == true){

                changed = true;
            }

            for (int j = size-1; j > 0; j--){

                x = size - 1;
                y = size - 2;

            
                // if we have pair to add
                if (board[i][j] == board[i][j-1] && board[i][j] != 0){

                    score += board[i][j] + board[i][j-1];
                    board[i][j] += board[i][j];
                    board[i][j-1] = 0;
                    changed = true;
                    shiftrowRight(i);
            
            }
            }
        }
        if (changed == true){

            addTile();
        }
    }
    /**
     * @brief Shifts every number to the Left if possible. Also adds
     *  tiles that are next together with the same number. Updates score if this
     *  happens.
     */
    public void moveLeft(){

        boolean changed = false;
        int x;
        int y;
        for (int i = size-1; i >= 0; i--){

            boolean check = shiftrowLeft(i);

            if (check == true){

                changed = true;
            }

            for (int j = 0; j < size-1; j++){

            
                // if we have pair to add
                if (board[i][j] == board[i][j+1] && board[i][j] != 0){

                    score += board[i][j] + board[i][j+1];
                    board[i][j] += board[i][j];
                    board[i][j+1] = 0;
                    changed = true;
                    shiftrowLeft(i);
            
            }
            }
        }
        if (changed == true){

            addTile();
        }
    }
    /**
     * @brief Shifts every number up if possible. Also adds
     *  tiles that are next together with the same number. Updates score if this
     *  happens.
     */
    public void moveUp(){

        boolean changed = false;
        int x;
        int y;
        for (int i = 0; i < size; i++){

            boolean check = shiftColumnUp(i);
            if (check == true){

                changed = true;
            }

            for (int j = 0; j < size-1; j++){

                x = size - 1;
                y = size - 2;

            
                // if we have pair to add
                if (board[j][i] == board[j+1][i] && board[j][i] != 0){

                    score += board[j][i] + board[j][i];
                    board[j][i] += board[j][i];
                    board[j+1][i] = 0;
                    changed = true;
                    shiftColumnUp(i);
            
            }
            }
        }
        if (changed == true){

            addTile();
        }
    }

    /**
     * @brief Shifts every number down if possible. Also adds
     *  tiles that are next together with the same number. Updates score if this
     *  happens.
     */
    public void moveDown(){

        boolean changed = false;
        int x;
        int y;
        for (int i = 0; i < size; i++){

            boolean check = shiftColumnDown(i);
            if (check == true){

                changed = true;
            }

            for (int j = size-1; j > 0; j--){

                x = size - 1;
                y = size - 2;

            
                // if we have pair to add
                if (board[j][i] == board[j-1][i] && board[j][i] != 0){

                    score += board[j][i] + board[j][i];
                    board[j][i] += board[j][i];
                    board[j-1][i] = 0;
                    changed = true;
                    shiftColumnDown(i);
            
            }
            }
        }
        if (changed == true){

            addTile();
        }
    }

    private boolean shiftrowRight(int row){

        int answer = -1;

        for (int i = 0; i < size; i++){

            int ans = shiftNumRight(row);

            if (ans == 1 ){

                answer = 1;
            }
        }
        return answer == 1;
    }

    private int shiftNumRight(int row){
        
        int ans = -1;

        for (int i = size-1; i > 0; i--){


            if (board[row][i] == 0 && board[row][i-1] != 0){

                board[row][i] = board[row][i-1];
                board[row][i-1] = 0;
                ans = 1;
            }
        }
    
        return ans;

        }

    private boolean shiftrowLeft(int row){

        int answer = -1;

        for (int i = 0; i < size; i++){

            int ans = shiftNumLeft(row);

            if (ans == 1 ){

                answer = 1;
            }
        }
        return answer == 1;
    }

    private int shiftNumLeft(int row){
        
        int ans = -1;

        for (int i = 0; i < size-1; i++){


            if (board[row][i] == 0 && board[row][i+1] != 0){

                board[row][i] = board[row][i+1];
                board[row][i+1] = 0;
                ans = 1;
            }
        }
    
        return ans;

        }
        
    private boolean shiftColumnUp(int row){

        int answer = -1;

        for (int i = 0; i < size; i++){

            int ans = shiftNumUp(row);

            if (ans == 1 ){

                answer = 1;
            }
        }
        return answer == 1;
    }

    private int shiftNumUp(int column){
        
        int ans = -1;

        for (int i = 0; i < size-1; i++){


            if (board[i][column] == 0 && board[i+1][column] != 0){

                board[i][column] = board[i+1][column];
                board[i+1][column] = 0;
                ans = 1;
            }
        }
    
        return ans;

        } 
    private boolean shiftColumnDown(int row){

        int answer = -1;

        for (int i = 0; i < size; i++){

            int ans = shiftNumDown(row);

            if (ans == 1 ){

                answer = 1;
            }
        }
        return answer == 1;
    }

    private int shiftNumDown(int column){
        
        int ans = -1;

        for (int i = size-1; i > 0; i--){


            if (board[i][column] == 0 && board[i-1][column] != 0){

                board[i][column] = board[i-1][column];
                board[i-1][column] = 0;
                ans = 1;
            }
        }
        return ans;
        }       
    }

