package com.bowling.entity;

import com.bowling.dao.ScoreDAO;
import org.junit.Test;

import java.util.List;

/**
 * Created by Akronys on 26/02/2015.
 */
public class getScoresByGame {

    @Test
    public void test(){

        List<Score> scores = new ScoreDAO().getScoresByGame(1);
        System.out.println(scores.get(0).getId());
    }
}
