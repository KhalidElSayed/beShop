package com.rxapps.beshop.service;

import com.rxapps.beshop.model.Shop;

import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

public interface ShopService {
    List<Shop> findAll();
    Shop findById(Long id);
    Shop findByBeaconId(String beaconId);
}
