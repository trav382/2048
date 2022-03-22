/**
 * file: TestBoardT.java
 * Author: Travis Moore (mooret12)
 * Revised: April 12 2021
 * 
 * Description: Testing for BoardT class.
 */

package src;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBoardT
{

    private BoardT board;

    @Before
    public void setUp(){

        board = new BoardT();
    }

    @After
    public void tearDown(){

        board = null;
    }

    @Test
    public void testGetCell(){

        board.setTile(0,0,128);
        board.setTile(1,1,64);
        assertTrue(board.getCell(0,0) == 128);
        assertTrue(board.getCell(1,1) == 64);
    }

    @Test
    public void testGetScore(){

        assertTrue(board.getScore() == 0);

    }

    @Test
    public void testGetScore2(){

        board.setTile(0,0,64);
        board.setTile(1,0,64);
        board.moveUp();
        assertTrue(board.getScore() >= 128);
    }


    @Test
    public void testGetScore3(){

        board.setTile(0,0,64);
        board.setTile(1,0,64);
        board.setTile(0,1,128);
        board.moveUp();
        board.moveLeft();
        assertTrue(board.getScore() >= 128);
    }

    @Test
    public void testMoveRight(){

        board.setTile(0,0,2);
        board.setTile(0,1,2);
        board.setTile(0,2,2);
        board.setTile(0,3,2);
        board.moveRight();

        assertTrue(board.getCell(0,3) == 4);
        assertTrue(board.getCell(0,2) == 4);

        board.moveRight();

        assertTrue(board.getCell(0,3) == 8);
    }

    @Test
    public void testMoveRight2(){

        board.setTile(1,0,2);
        board.setTile(1,1,2);
        board.setTile(1,2,2);
        board.setTile(1,3,4);

        board.moveRight();

        assertTrue(board.getCell(1,3) == 4);
        assertTrue(board.getCell(1,2) == 4);
        assertTrue(board.getCell(1,1) == 2);

        board.moveRight();
        assertTrue(board.getCell(1,3) == 8);
    }

    @Test
    public void testMoveLeft(){

        board.setTile(1,0,4);
        board.setTile(1,1,4);
        board.setTile(1,2,4);
        board.setTile(1,3,8); 

        board.moveLeft();

        assertTrue(board.getCell(1,0) == 8);
        assertTrue(board.getCell(1,1) == 4);

    }

    @Test
    public void testMoveLeft2(){

        board.setTile(3,0,8);
        board.setTile(3,1,8);
        board.setTile(3,2,8);
        board.setTile(3,3,8); 

        board.moveLeft();

        assertTrue(board.getCell(3,0) == 16);
        assertTrue(board.getCell(3,1) == 16);
        assertFalse(board.getCell(3,2) == 8);
    }

    @Test
    public void testMoveUp(){


        board.setTile(0,0,8);
        board.setTile(1,0,8);
        board.setTile(2,0,8);
        board.setTile(3,0,8); 

        board.moveUp();

        assertTrue(board.getCell(0,0) == 16);
        assertTrue(board.getCell(1,0) == 16);
        assertTrue(board.getCell(2,0) != 8);

    }

    @Test
    public void testMoveUp2(){


        board.setTile(0,2,2);
        board.setTile(1,2,2);
        board.setTile(2,2,0);
        board.setTile(3,2,0); 

        board.moveUp();

        assertTrue(board.getCell(0,2) == 4); 
    }


    @Test
    public void testMoveDown(){


        board.setTile(0,2,2);
        board.setTile(1,2,2);
        board.setTile(2,2,0);
        board.setTile(3,2,0); 

        board.moveDown();

        assertTrue(board.getCell(3,2) == 4); 
    }

    @Test // special case
    public void testMoveDown2(){


        board.setTile(0,2,4);
        board.setTile(1,2,4);
        board.setTile(2,2,4);
        board.setTile(3,2,4); 

        board.moveDown();

        assertTrue(board.getCell(3,2) == 8);
        assertTrue(board.getCell(2,2) == 8); 
        assertTrue(board.getCell(1,2) != 8);
    }

    @Test //Previous bug, need to make sure works
    public void testgameOver(){

        board.setTile(0,0,16);
        board.setTile(0,1,2);
        board.setTile(0,2,8);
        board.setTile(0,3,4);

        board.setTile(1,0,16);
        board.setTile(1,1,256);
        board.setTile(1,2,8);
        board.setTile(1,3,0);

        board.setTile(2,0,4);
        board.setTile(2,1,128);
        board.setTile(2,2,32);
        board.setTile(2,3,0);

        board.setTile(3,0,2);
        board.setTile(3,1,4);
        board.setTile(3,2,16);
        board.setTile(3,3,0);


        assertFalse(board.gameOver());

    }

    @Test //Game over situation
    public void testgameOver2(){

        board.setTile(0,0,2);
        board.setTile(0,1,4);
        board.setTile(0,2,8);
        board.setTile(0,3,12);

        board.setTile(1,0,16);
        board.setTile(1,1,32);
        board.setTile(1,2,64);
        board.setTile(1,3,2);

        board.setTile(2,0,64);
        board.setTile(2,1,256);
        board.setTile(2,2,512);
        board.setTile(2,3,4);

        board.setTile(3,0,2);
        board.setTile(3,1,8);
        board.setTile(3,2,1024);
        board.setTile(3,3,8);


        assertTrue(board.gameOver());

    }

    @Test //Game over situation
    public void testgameOver3(){

        board.addTile();
        board.addTile();
        board.addTile();
        board.addTile();
        board.addTile();
        board.addTile();
        board.addTile();

        assertFalse(board.gameOver());

    }


















}