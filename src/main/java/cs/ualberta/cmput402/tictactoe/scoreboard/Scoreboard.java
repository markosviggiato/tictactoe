package cs.ualberta.cmput402.tictactoe.scoreboard;

import cs.ualberta.cmput402.tictactoe.board.Board.Player;

import java.util.Hashtable;

public class Scoreboard {

    private Hashtable<Player, Integer> statistics;

    public Scoreboard() {
        statistics = new Hashtable<Player, Integer>();
        statistics.put(Player.X, 0);
        statistics.put(Player.O, 0);
        statistics.put(Player.NONE, 0);
    }

    public void printScoreboard() {

    }

    public void incrementPlayerWins(Player player) {
        Integer curStat = statistics.get(player);
        Integer newStat = curStat + 1;
        statistics.put(player, newStat);
    }

    public void incrementTies() {
        incrementPlayerWins(Player.NONE);
    }

    public Integer getPlayerWins(Player player) {
        return statistics.get(player);
    }

    public Integer getTies() {
        return getPlayerWins(Player.NONE);
    }

}
