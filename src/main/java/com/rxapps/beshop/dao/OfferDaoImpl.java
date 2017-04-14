package com.rxapps.beshop.dao;

import com.rxapps.beshop.model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Muslims on 1/30/2017.
 */

@Repository
public class OfferDaoImpl implements OfferDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> findOfferByShopBeaconId(String id) {
        Session session = sessionFactory.openSession();

        List<Offer> offers = session.getNamedQuery("findShopOffersByBeaconId")
                .setParameter("id", id)
                .getResultList();

        return offers;
    }
}
