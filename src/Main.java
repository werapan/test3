import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Board board;
    private static Scanner sc = new Scanner(System.in);
    private static int col;
    private static int row;

    public static void main(String[] args) {
        board = new Board();
        while(true) {
            System.out.println(board.getBoardString());
            boolean status;
            do {
                inputColRow();
                status = board.put(col, row);
            } while (!status);

            if (board.checkWin(col, row)) {
                System.out.println(board.getCurrentPlayer() + " is Win");
                board.reset();
            }
            board.switchPlayer();
        }
    }

    private static void inputColRow() {
        System.out.print(board.getCurrentPlayer() + " Col>");
        col=sc.nextInt();
        System.out.print(board.getCurrentPlayer() + " Row>");
        row=sc.nextInt();

    }
}
