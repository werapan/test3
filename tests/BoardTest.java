import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBoardString() {
        Board board = new Board();
        String boardString = board.getBoardString();
//        System.out.println(boardString);
        assertEquals(true, boardString.equals(" 012\n0---\n1---\n2---\n"));
    }

    @Test
    void getCurrentPlayer() {
        Board board = new Board();
        String player = board.getCurrentPlayer();
        assertEquals("X",player);
    }

    @Test
    void switchPlayer() {
        Board board = new Board();
        board.switchPlayer();
        assertEquals("O",board.getCurrentPlayer());
        board.switchPlayer();
        assertEquals("X",board.getCurrentPlayer());
    }

    @Test
    void putColRow() {
        Board board = new Board();
        boolean status = board.put(0,0);
        String boardString = board.getBoardString();
        assertEquals(true, boardString.equals(" 012\n0X--\n1---\n2---\n"));
        assertEquals(true,status);

    }

    @Test
    void putError() {
        Board board = new Board();
        boolean status = board.put(0,0);
        String boardString = board.getBoardString();
        assertEquals(true, boardString.equals(" 012\n0X--\n1---\n2---\n"));
        assertEquals(true,status);

        status = board.put(0,0);
        boardString = board.getBoardString();
        assertEquals(true, boardString.equals(" 012\n0X--\n1---\n2---\n"));
        assertEquals(false,status);
    }
    @Test
    void putOverOutOfBound() {
        Board board = new Board();
        boolean status = board.put(3,3);
        String boardString = board.getBoardString();
        assertEquals(true, boardString.equals(" 012\n0---\n1---\n2---\n"));
        assertEquals(false,status);

        status = board.put(-1,-1);
        boardString = board.getBoardString();
        assertEquals(true, boardString.equals(" 012\n0---\n1---\n2---\n"));
        assertEquals(false,status);
    }

    @Test
    void resetBoard() {
        Board board = new Board();
        board.put(0,0);
        board.put(1,0);
        board.put(2,0);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0XXX\n1---\n2---\n"));
        board.reset();
        assertEquals(true, board.getBoardString().equals(" 012\n0---\n1---\n2---\n"));
    }
    @Test
    void checkWin1() {
        Board board = new Board();
        board.put(0,0);
        board.put(1,0);
        board.put(2,0);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0XXX\n1---\n2---\n"));
        assertEquals(true,board.checkWin(2,0));
        assertEquals(true,board.checkWin(1,0));
        assertEquals(true,board.checkWin(0,0));
        assertEquals(false,board.checkWin(2,1));
        assertEquals(false,board.checkWin(1,2));
    }
    @Test
    void checkWin2() {
        Board board = new Board();
        board.put(0,1);
        board.put(1,1);
        board.put(2,1);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0---\n1XXX\n2---\n"));
        assertEquals(true,board.checkWin(2,1));
        assertEquals(true,board.checkWin(1,1));
        assertEquals(true,board.checkWin(0,1));
        assertEquals(false,board.checkWin(2,0));
        assertEquals(false,board.checkWin(1,0));
    }
    @Test
    void checkWin3() {
        Board board = new Board();
        board.put(0,2);
        board.put(1,2);
        board.put(2,2);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0---\n1---\n2XXX\n"));
        assertEquals(true,board.checkWin(2,2));
        assertEquals(true,board.checkWin(1,2));
        assertEquals(true,board.checkWin(0,2));
        assertEquals(false,board.checkWin(2,0));
        assertEquals(false,board.checkWin(1,0));
    }

    @Test
    void checkWin4() {
        Board board = new Board();
        board.put(0,0);
        board.put(0,1);
        board.put(0,2);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0X--\n1X--\n2X--\n"));
        assertEquals(true,board.checkWin(0,0));
        assertEquals(true,board.checkWin(0,1));
        assertEquals(true,board.checkWin(0,2));
        assertEquals(false,board.checkWin(2,0));
        assertEquals(false,board.checkWin(1,0));
    }

    @Test
    void checkWin5() {
        Board board = new Board();
        board.put(1,0);
        board.put(1,1);
        board.put(1,2);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0-X-\n1-X-\n2-X-\n"));
        assertEquals(true,board.checkWin(1,0));
        assertEquals(true,board.checkWin(1,1));
        assertEquals(true,board.checkWin(1,2));
        assertEquals(false,board.checkWin(2,0));
        assertEquals(false,board.checkWin(0,0));
    }

    @Test
    void checkWin6() {
        Board board = new Board();
        board.put(0,0);
        board.put(2,0);
        board.put(1,1);
        board.put(0,2);
        board.put(2,2);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0X-X\n1-X-\n2X-X\n"));
        assertEquals(true,board.checkWin(0,0));
        assertEquals(true,board.checkWin(1,1));
        assertEquals(true,board.checkWin(2,2));
        assertEquals(true,board.checkWin(2,0));
        assertEquals(true,board.checkWin(0,2));
        assertEquals(false,board.checkWin(0,1));
        assertEquals(false,board.checkWin(2,1));
        assertEquals(false,board.checkWin(1,0));
        assertEquals(false,board.checkWin(1,2));
    }

    @Test
    void checkWin7() {
        Board board = new Board();
        board.put(0,0);
        board.put(2,0);
        board.put(1,1);
        board.put(0,2);
        board.put(2,2);
        System.out.println(board.getBoardString());
        assertEquals(true, board.getBoardString().equals(" 012\n0X-X\n1-X-\n2X-X\n"));
        assertEquals(true,board.checkWin(0,0));
        assertEquals(true,board.checkWin(1,1));
        assertEquals(true,board.checkWin(2,2));
        assertEquals(true,board.checkWin(2,0));
        assertEquals(true,board.checkWin(0,2));
        assertEquals(false,board.checkWin(0,1));
        assertEquals(false,board.checkWin(2,1));
        assertEquals(false,board.checkWin(1,0));
        assertEquals(false,board.checkWin(1,2));
    }
}