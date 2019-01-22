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
        System.out.println(" X | O | Tie");
        System.out.println("-------------");
        System.out.println(" " + getPlayerWins(Player.X) +
                " | " + getPlayerWins(Player.O) +
                " |  " + getTies());
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

    public Integer getPlayerLosses(Player player) {
        Player otherPlayer;
        if(player.equals(Player.X)) {
            otherPlayer = Player.O;
        } else {
            otherPlayer = Player.X;
        }
        return getPlayerWins(otherPlayer);
    }

    public Integer getTies() {
        return getPlayerWins(Player.NONE);
    }

}
