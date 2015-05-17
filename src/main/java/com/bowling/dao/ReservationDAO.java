package com.bowling.dao;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.bowling.entity.Reservation;
import com.bowling.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ReservationDAO extends Template {

    public Reservation getReservationById(int reservation_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Reservation.class)
                .add(Restrictions.eq("id", reservation_id));

        criteria.setMaxResults(1);

        Reservation reservation = (Reservation) criteria.uniqueResult();

        session.close();

        return reservation;
    }

    public List<Reservation> getAll() {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Reservation.class);

        List<Reservation> reservations = (List<Reservation>)criteria.list();

        session.close();

        return reservations;
    }
}
