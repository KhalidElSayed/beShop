package com.rxapps.beshop.service;

import com.rxapps.beshop.dao.ShopDao;
import com.rxapps.beshop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Override
    public List<Shop> findAll() {
        return shopDao.findAll();
    }

    @Override
    public Shop findById(Long id) {
        return shopDao.findById(id);
    }

    @Override
    public Shop findByBeaconId(String beaconId) {
        return shopDao.findByBeaconId(beaconId);
    }
}
