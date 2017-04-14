package com.rxapps.beshop.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Muslims on 1/21/2017.
 */

@Entity
@NamedQueries({@NamedQuery(name = "findShopOffersByBeaconId", query = "SELECT o FROM Offer o WHERE o.shop.beaconId = :id")})
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Long id;

    @Column(name = "offer_title")
    private String title;

    @Column(name = "offer_details")
    private String details;

    @Column(name = "offer_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Offer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
