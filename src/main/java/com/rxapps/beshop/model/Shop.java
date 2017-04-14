package com.rxapps.beshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muslims on 1/21/2017.
 */

@Entity
@NamedQueries({@NamedQuery(name = "findByBeaconId", query = "SELECT s FROM Shop s WHERE s.beaconId = :id")})
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    @NotNull
    @Pattern(regexp = "[0-9a-zA-Z]{4}")
    @Column(name = "shop_beacon_id")
    private String beaconId;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "shop_type")
    private String type;

    @Column(name = "shop_image")
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "shop")
    private List<Offer> offers = new ArrayList<>();

    public Shop() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(String beaconId) {
        this.beaconId = beaconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Offer> getOffers() {
        return offers;
    }
}
