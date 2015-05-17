package com.bowling.dao;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.bowling.entity.User;
import com.bowling.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDAO extends Template {

    public User getUserById(int user_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq("user.id", user_id));

        criteria.setMaxResults(1);

        User user = (User)criteria.uniqueResult();

        session.close();

        return user;
    }

    public List<User> getAll() {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);

        List<User> users = (List<User>)criteria.list();

        session.close();

        return users;
    }
}


