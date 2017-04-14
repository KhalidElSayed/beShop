package com.rxapps.beshop.service;

import com.rxapps.beshop.dao.OfferDao;
import com.rxapps.beshop.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Muslims on 1/30/2017.
 */

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferDao offerDao;

    @Override
    public List<Offer> getShopOffers(String id) {
        return offerDao.findOfferByShopBeaconId(id);
    }
}
