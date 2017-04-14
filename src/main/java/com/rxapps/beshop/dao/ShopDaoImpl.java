package com.rxapps.beshop.dao;

import com.rxapps.beshop.model.Shop;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

@Repository
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Shop> findAll() {
        Session session = sessionFactory.openSession();

//        List<Shop> shops = session.createCriteria(Shop.class).list();

        CriteriaQuery<Shop> criteriaQuery = session.getCriteriaBuilder().createQuery(Shop.class);

        criteriaQuery.from(Shop.class);

        List<Shop> shops = session.createQuery(criteriaQuery).getResultList();

        session.close();

        return shops;
    }

    @Override
    public Shop findById(Long id) {
        Session session = sessionFactory.openSession();

        Shop shop = session.get(Shop.class, id);

        Hibernate.initialize(shop.getOffers());

        session.close();

        return shop;
    }

    @Override
    public Shop findByBeaconId(String beaconId) {
        Session session = sessionFactory.openSession();

        Shop shop = (Shop) session.getNamedQuery("findByBeaconId")
                .setParameter("id", beaconId)
                .uniqueResult();

        Hibernate.initialize(shop.getOffers());

        session.close();

        return shop;
    }
}
