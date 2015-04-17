package entity;

import com.bowling.dao.*;
import com.bowling.entity.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Akronys on 22/02/2015.
 */
public class ScoreTest {

    @Test
    public void insertScores() {

        Player player1 = new Player("Bob", "Lennon");
        Player player2 = new Player("Jack", "Sparrow");

        new PlayerDAO().save(player1);
        new PlayerDAO().save(player2);

        Lane lane1 = new Lane("piste_1", true);
        Game game = new Game(10, lane1);

        Reservation res = new Reservation();
        res.setPlayers(Arrays.asList(new Player[]{player1}));
        res.setGames(Arrays.asList(new Game[]{game}));

        Score score1 = new Score(1, player1, game);
        score1.setFirstRoll(4);
        score1.setSecondRoll(3);
        score1.setRoundPoints(7);

        new LaneDAO().save(lane1);
        new GameDAO().save(game);
        new ReservationDAO().save(res);
        new ScoreDAO().save(score1);

    }

}
