package com.rxapps.beshop.service;

import com.rxapps.beshop.model.Offer;

import java.util.List;

/**
 * Created by Muslims on 1/30/2017.
 */

public interface OfferService {
    List<Offer> getShopOffers(String id);
}
