package com.rxapps.beshop.dao;

import com.rxapps.beshop.model.Offer;

import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

public interface OfferDao {
    List<Offer> findOfferByShopBeaconId(String id);
}
