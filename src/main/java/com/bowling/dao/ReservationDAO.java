package com.bowling.dao;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.bowling.entity.Reservation;
import com.bowling.util.Template;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends Template {

    public Reservation getReservationById(int reservation_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Reservation reservation = (Reservation) session.load(Reservation.class, reservation_id);

        session.close();

        return reservation;
    }

    public List<Reservation> getAll() {
        List<Reservation> bookings = new ArrayList<Reservation>();

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        bookings = session.createCriteria(Reservation.class).list();

        session.close();

        return bookings;
    }
}
