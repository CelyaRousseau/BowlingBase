package com.bowling.dao;

import com.bowling.entity.Player;
import com.bowling.entity.Reservation;
import com.bowling.entity.Score;
import com.bowling.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Akronys on 21/02/2015.
 */
public class PlayerDAO extends Template {
    public List<Player> getUsersForGame(int game_id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Reservation.class)
                .add(Restrictions.eq("games_id", game_id));

        criteria.setMaxResults(1);

        Reservation reservation = (Reservation)criteria.uniqueResult();

        List<Player> players = reservation.getPlayers();

        session.close();

        return players;
    }

    public List<Player> getScoresByGameId(int game_id)
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Player.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        List<Player> players = (List<Player>)criteria.list();

        players.stream()
                .filter(player -> player.getScores().size()!=0)
                .forEach(player -> {
                    List<Score> scores = player.getScores().stream().
                            filter(score -> score.getGame().getId() == game_id).
                            collect(Collectors.toList());
                    player.getScores().clear();
                    player.getScores().addAll(scores);
                });
        session.close();

        return players;
    }
}
