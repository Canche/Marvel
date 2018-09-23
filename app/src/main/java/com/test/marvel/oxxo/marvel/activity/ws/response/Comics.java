package com.test.marvel.oxxo.marvel.activity.ws.response;

import java.util.List;

/**
 * Created by Will on 21/09/2018.
 */

public class Comics {

    private Integer available;
    private Integer returned;
    private String collectionURI;

    private List<ItemsComics> items;

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ItemsComics> getItems() {
        return items;
    }

    public void setItems(List<ItemsComics> items) {
        this.items = items;
    }
}
