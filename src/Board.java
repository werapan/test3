public class Board {
    private String table[][] = {{" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"},

    };
    private String player="X";

    public String getBoardString() {
        String boardString="";
        for(int i = 0; i< table.length; i++) {
            for(int j = 0; j< table.length; j++) {
                boardString=boardString+ table[i][j];
            }
            boardString=boardString+"\n";
        }
        return boardString;
    }

    public String getCurrentPlayer() {
        return player;
    }

    /*
     * switchPlayer() - switch player when end turn.
     *      The players are X and O.
     */
    public void switchPlayer() {
        if(player=="X") {
            player="O";
        }
        else {
            player="X";
        }
    }

    /*
     * put() - put the current user symbol to table at col and row.
     *  @param col the column of ox table
     *  @param row the row of ox table
     */
    public boolean put(int col, int row) {

        if(row>=3 || row<0 || col>=3 || col<0) {
            return false;
        }
        if(!table[row+1][col+1].equals("-")) {
            return false;
        }
        table[row+1][col+1]=this.getCurrentPlayer();
        return true;
    }

    /*
     * checkRow() - check win status at row
     *      The
     *  @param row the row of ox table
     */
    private boolean checkRow(int row) {
        for(int i=1;i<4;i++) {
            if(!table[row+1][i].equals(this.getCurrentPlayer())) {
                return false;
            }
        }
        return true;
    }
    /*
     * checkCol() - ตรวจว่า
     *      ตรวจว่าใน column นั้นมีตัวอักษรที่เหมือนกันหรือไม่
     *  @param col คอลัมภ์ของ table
     */
    private boolean checkCol(int col) {
        for(int i=1;i<4;i++) {
            if(!table[i][col+1].equals(this.getCurrentPlayer())) {
                return false;
            }
        }
        return true;
    }

    /*
     * checkColRow() - check win status at column and row
     *  There are 3 cases:
     *      - row
     *      - col
     *      - ทะแยงมุม
     */
    public boolean checkColRow(int col, int row) {
        if(col==row) {
           for(int i=1;i<4;i++) {
               if(!table[i][i].equals(this.getCurrentPlayer())) {
                   return false;
               }
           }
           return true;
        }
        if(col+row==2) {
            for(int i=1;i<4;i++) {
                if(!table[i][4-i].equals(this.getCurrentPlayer())) {
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    public boolean checkWin(int col, int row) {

        if(checkRow(row)) {
            return true;
        }
        if(checkCol(col)) {
            return true;
        }
        if(checkColRow(col,row)) {
            return true;
        }
        return false;
    }

    public void reset() {
        
    }
}
