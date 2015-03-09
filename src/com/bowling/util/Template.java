package com.bowling.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class Template {

    public Serializable save(Object object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Serializable seri = session.save(object);
        session.getTransaction().commit();

        return seri;
    }

    public void update(Object object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();

    }

    public void delete(Object object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    public <T> T get(Class<T> clazz, Serializable serializable) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        T object = (T) session.get(clazz, serializable);
        session.getTransaction().commit();

        return object;
    }

    protected SessionFactory getSessionFactory() {
        return UtilHibernate.getSessionFactory();
    }

}
