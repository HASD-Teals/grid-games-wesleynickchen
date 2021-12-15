import java.util.Scanner;

public class App {
    public static void main(String[] args){
        /*System.out.println("Squid Games");
        char board[][] = createboard(10, 10, '*');
        gravplace(board, 7, '4', '*');
        gravplace(board, 2, '2', '*');
        gravplace(board, 2, '2', '*');
        gravplace(board, 1, '2', '*');
        gravplace(board, 3, '2' , '*');
        //reverserow(board, 9);
        print2d(board);
        hWin(board, '2' , 3);
        vWin(board, '2' , 2);
        dWin(board, '2', 2, true);
       // reverseColumn(board, 8);
        blast(board, 0, 0, 'p');
        print2d(board);
        //sample code ^^^
        */

        game();
    }

    public static char[][] createboard(int rows, int cols, char charact) {
        char arr[][] = new char[rows][cols];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = charact;
            }
        }
        return arr;
    }
    public static void write(char[][] arrIn ,int row, int cols, char bkChar, char charact) {
        //index at 0
        if(arrIn[row][cols] == bkChar){
            arrIn[row][cols] = charact;
        }
        
    }
    public static void write(char[][] arrIn ,int row, int cols, char charact, char bkChar, boolean Overwrite) {
        //index at 0
        if(arrIn[row][cols] == bkChar || Overwrite){
            arrIn[row][cols] = charact;
        }
        
    }
    
    public static void print2d(char[][] arrIn) {
        for (int ii = 0; ii < arrIn.length; ii++) {
            for (int jj = 0; jj < arrIn[0].length; jj++) {
                System.out.print(arrIn[ii][jj] + " ");
            }
            System.out.println();
        }
    }
    public static boolean hWin(char[][] arr, char inchar, int len, char bkchar) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
               if(arr[i][j] != bkchar){
                    int iIndex = j;
                    while (arr[i][iIndex] == inchar){
                        //'System.out.println(i + " " + (iIndex - j));
                        if (iIndex - j >= len -1) {
                            System.out.println("Hwin at row: " + i + " and at colum: " + j);
                            return true;
                            
                        }
                        
                        iIndex++;
                        if(iIndex % arr.length <= 0){
                            break;
                        }
                        
                    }
                    if(iIndex <= arr.length){
                       j += iIndex - j;
                    }
                    else{
                        j = 0;
                        i++;
                    }
               }
               
            }
        }
        return false;
    }
    public static boolean vWin(char[][] arr, char inchar, int len, char bkchar) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
               if(arr[j][i] != bkchar){
                    int iIndex = j;
                    while (arr[iIndex][i] == inchar){
                        //'System.out.println(i + " " + (iIndex - j));
                        if (iIndex - j >= len -1) {
                            System.out.println("Vwin at row: " + j + " and at colum: " + i);
                            return true;
                        }
                        iIndex++;
                        if(iIndex % arr.length <= 0){
                            break;
                        }
                        
                    }
                    if(iIndex <= arr.length){
                       j += iIndex - j;
                    }
                    else{
                        j = 0;
                        i++;
                    }
               }
            }
        }
        return false;
    }
    public static boolean dWin(char[][] arr, char inchar, int len, Boolean slant) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int iindex = i, jindex = j;
                while (arr[iindex][jindex] == inchar) {
                    if(jindex - j >= len -1){
                        System.out.println("Dwin at row: " + i + " and at colum: " + j);
                        return true;
                    }
                    iindex += (slant ? -1 : 1);
                    jindex++;
                    
                    if((iindex >= arr.length || jindex >= arr.length) || (iindex < 0 || jindex < 0)){
                        break;
                    }

                }
            }
        }
        return false;
    }

    public static void gravplace(char board[][], int rows, char charact, char bkchar) {
        boolean retbool = false;
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][rows] != bkchar || i == board[0].length - 1) {
                if(board[board.length -1][rows] == bkchar){
                    retbool = true;
                }
                write(board, (i - (retbool ? 0 : 1)), rows, bkchar, charact);
                break; 
            }
            
        }
    }

    public static void reverserow(char[][] board, int row) {
        char[] temp = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            temp[i] = board[row][i];
        }
        for (int i = 0; i < temp.length; i++) {
            board[row][i] = temp[temp.length - i - 1];
            //System.out.println(board[row][i]);
        }
    }
    public static void reverseColumn(char[][] board, int col) {
        char[] temp = new char[board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            temp[i] = board[i][col];
        }
        for (int i = 0; i < temp.length; i++) {
            board[i][col] = temp[temp.length - i - 1];
            //System.out.println(board[i][col]);
        }
    }
    public static void clearBoard(char[][] board, char charact) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = charact;
            }
        }
    }
    public static void blast(char[][] board, int row, int col, char charact) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i==j && i== 0) {
                    continue;
                }
                if((row + i < 10 && col + j < 10) && (row + i > -1 && col + j > -1)){
                    board[row + i][col + j] = charact;
                }
               

            }
        }
    }
    private static void game() {
        boolean running = true;
        Scanner input = new Scanner(System.in);
        System.out.println("choose your board size:");
        int size = input.nextInt();
        System.out.println("choose your background character:");
        String charactBackString = input.next();
        char charactBack = charactBackString.charAt(0);
        System.out.println("PLayer 1 type your character:");
        String charact1String = input.next();
        char charact1 = charact1String.charAt(0);
        //char charact1 = input.nextLine().charAt(0);
        System.out.println("PLayer 2 type your character:");
        String charact2String = input.next();
        char charact2 = charact2String.charAt(0);
        //char charact2 = input.nextLine().charAt(0);
        
        char[][] board = createboard(size, size, charactBack);
        while(running){
            //player1 placing
            System.out.println("player1 turn");
            int loc1 = input.nextInt();
            gravplace(board,  (loc1 > board.length) ? board.length -1 : loc1, charact1, charactBack);
            //player2 placing
            System.out.println("player2 turn");
            int loc2 = input.nextInt();
            gravplace(board,  (loc2 > board.length) ? board.length -1 : loc2, charact2, charactBack);

            print2d(board);
            if(hWin(board, charact1, 4, charactBack) || vWin(board, charact1, 4, charactBack) || dWin(board, charact1, 4, true) || dWin(board, charact1, 4, false)){
                System.out.println("player1 Win!!");
                running = false;
            }
            if(hWin(board, charact2, 4, charactBack) || vWin(board, charact2, 4, charactBack) || dWin(board, charact2, 4, true) || dWin(board, charact2, 4, false)){
                System.out.println("player2 Win!!");
                running = false;
            }
        }
        input.close();
        //find how to return
    }
}
