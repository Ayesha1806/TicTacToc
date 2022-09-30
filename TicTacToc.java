package Tic_Tac_Toc;

import java.util.Random;
import java.util.Scanner;

public class TicTacToc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        printBoard(board);
        while(true) {
            playerTurn(board, s);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);

        }
     s.close();

    }
    private static boolean  isGameFinished(char[][] board){
        if(hasContestantWon(board,'X')){
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }
        if(hasContestantWon(board,'o')){
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The Game Is End In A Tie");
        return true;

    }
    private static boolean hasContestantWon(char[][] board , char input){
        if((board[0][0] == input && board[0][1] == input && board[0][2] == input) ||
                (board[1][0] == input && board[1][1] == input && board[1][2] == input) ||
                ( board[2][0] == input && board[2][1] == input && board[2][2] == input) ||


                (board[0][0] == input && board[1][0] == input && board[2][0] == input) ||
                (board[0][1] == input && board[1][1] == input && board[2][1] == input) ||
                ( board[0][2] == input && board[1][2] == input && board[2][2] == input) ||

                (board[0][0] == input && board[1][1] == input && board[2][2] == input) ||
                (board[0][0] == input && board[1][1] == input && board[2][0] == input) ){
            return true;
        }
        return false;


    }
    public static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {

            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, String.valueOf(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove),'o');
    }

    private static boolean isValidMove(char[][] board, String position) {
        switch (position){
            case "1" :
               return (board[0][0] == ' ');
            case "2" :
               return (board[0][1] == ' ');
            case "3" :
              return  (board[0][2] == ' ');
            case "4" :
              return  (board[1][0] == ' ');
            case "5" :
               return (board[1][1] == ' ');
            case "6" :
               return (board[1][2] == ' ');
            case "7" :
               return (board[2][0] == ' ');
            case "8" :
               return (board[2][1] == ' ');
            case "9" :
               return  (board[2][2] == ' ');
            default:
                return false;
        }
        
    }
    public static void playerTurn(char[][] board, Scanner s){

        String userInput;
        while(true){
            System.out.println("Would You Like To Play? (1-9)");
            userInput=s.nextLine();
            if(isValidMove(board,userInput)){
                break;
            }
            else{
                System.out.println(userInput + "is not valid move. ");
            }
        }
        placeMove(board,userInput,'X');
    }

    private static void placeMove(char[][] board, String position , char input) {
        switch (position){
            case "1" :
                board[0][0]=input;
                break;
            case "2" :
                board[0][1]=input;
                break;
            case "3" :
                board[0][2]=input;
                break;
            case "4" :
                board[1][0]=input;
                break;
            case "5" :
                board[1][1]=input;
                break;
            case "6" :
                board[1][2]=input;
                break;
            case "7" :
                board[2][0]=input;
                break;
            case "8" :
                board[2][1]=input;
                break;
            case "9" :
                board[2][2]=input;
                break;
            default:
                System.out.println(":(");
        }
        printBoard(board);
    
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);

    }
}
