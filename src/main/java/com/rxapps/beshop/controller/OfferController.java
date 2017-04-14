package com.rxapps.beshop.controller;

import com.rxapps.beshop.model.Offer;
import com.rxapps.beshop.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

@RestController
@RequestMapping(value = "/beacon/api")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/getShopOffers", method = RequestMethod.POST)
    public ResponseEntity<List<Offer>> listShopOffers(@RequestParam(value = "beaconId") String id) {
        List<Offer> offers = offerService.getShopOffers(id);
        return new ResponseEntity<List<Offer>>(offers, HttpStatus.OK);
    }
}
