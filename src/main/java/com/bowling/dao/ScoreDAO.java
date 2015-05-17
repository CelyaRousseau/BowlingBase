package com.bowling.dao;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.bowling.entity.Score;
import com.bowling.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ScoreDAO extends Template {


    public Score getScoresByGameRoundAndUser(int game_id, int round_id, int user_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Score.class)
                .add(Restrictions.eq("game.id", game_id))
                .add(Restrictions.eq("round", round_id))
                .add(Restrictions.eq("player.id", user_id));

        criteria.setMaxResults(1);

        Score score = (Score)criteria.uniqueResult();

        session.close();

        return score;
    }

    public List<Score> getScoresByGame(int game_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Score.class)
                .add(Restrictions.eq("game.id", game_id));

        List<Score> scores = (List<Score>)criteria.list();

        session.close();

        return scores;
    }


}
