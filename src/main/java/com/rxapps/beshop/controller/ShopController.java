package com.rxapps.beshop.controller;

import com.rxapps.beshop.model.Shop;
import com.rxapps.beshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

@RestController
@RequestMapping(value = "/beacon/api")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/listShops", method = RequestMethod.POST)
    public ResponseEntity<List<Shop>> listShops() {
        List<Shop> shops = shopService.findAll();
        return new ResponseEntity<List<Shop>>(shops, HttpStatus.OK);
    }

    @RequestMapping(value = "/getShopById", method = RequestMethod.POST)
    public ResponseEntity<Shop> getShopById(@RequestParam(value = "id") Long id) {
        Shop shop = shopService.findById(id);
        return new ResponseEntity<Shop>(shop, HttpStatus.OK);
    }

    @RequestMapping(value = "/getShop", method = RequestMethod.POST)
    public ResponseEntity<Shop> getShop(@RequestParam(value = "beaconId") String beaconId) {
        Shop shop = shopService.findByBeaconId(beaconId);
        return new ResponseEntity<Shop>(shop, HttpStatus.OK);
    }
}
