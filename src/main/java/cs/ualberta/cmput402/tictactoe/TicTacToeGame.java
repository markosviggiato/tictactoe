package cs.ualberta.cmput402.tictactoe;

import cs.ualberta.cmput402.tictactoe.board.Board;
import cs.ualberta.cmput402.tictactoe.board.Board.Player;
import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;
import cs.ualberta.cmput402.tictactoe.scoreboard.Scoreboard;

import java.util.Scanner;

/**
 * Created by snadi on 2018-07-18.
 */
public class TicTacToeGame {

    private Board board;
    private Scoreboard scoreboard;

    public TicTacToeGame(){
        board = new Board();
        scoreboard = new Scoreboard();
    }

    public void promptNextPlayer(){
        switch(board.getCurrentPlayer()){
            case X:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;
            case O:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;

        }
    }

    public void playGame(){
        Scanner keyboardScanner = new Scanner(System.in);

        while (board.getWinner() == null && !board.getTieStatus()){
            board.printBoard();
            promptNextPlayer();
            String line = keyboardScanner.nextLine();
            String input[] = line.split(",");
            try {
                board.playMove(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            } catch (InvalidMoveException e) {
                System.out.println("Invalid coordinates. Try again");
                promptNextPlayer();
            }
        }

        board.printBoard();

        if(board.getTieStatus()) {
            scoreboard.incrementTies();
            System.out.println("It is no longer possible for either player to win. The game is a tie!");
        }
        else {
            scoreboard.incrementPlayerWins(board.getWinner());
            System.out.println("Player " + board.getWinner() + " has won the game!");
        }

        printScoreboard();

    }

    public boolean playAgain() {
        Scanner keyboardScanner = new Scanner(System.in);
        boolean playAgain = false;

        while(true) {
            System.out.println("Would you like to play again (y,n)? ");
            String line = keyboardScanner.nextLine().toLowerCase();
            if (line.equals("y")) {
                playAgain = true;
                break;
            } else if (line.equals("n")) {
                break;
            }
            System.out.println("Invalid Response. Try again.");
        }

        return playAgain;
    }

    public void clearBoard() {
        board = new Board();
    }

    public void printScoreboard() {
        System.out.println();
        scoreboard.printScoreboard();
        System.out.println();
    }

    public static void main(String args[]){
        TicTacToeGame game = new TicTacToeGame();

        while (true) {
            game.playGame();
            if (game.playAgain()) {
                game.clearBoard();
            }
            else {
                break;
            }
        }
    }
}
