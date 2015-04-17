package com.bowling.dao;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.bowling.entity.User;
import com.bowling.util.Template;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends Template {

    public User getUserById(int user_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        User user = (User) session.load(User.class, user_id);

        session.close();

        return user;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<User>();

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        users = session.createCriteria(User.class).list();

        session.close();

        return users;
    }
}


