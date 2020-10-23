package com.jydev.covidapp.network.data;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.util.List;

public class CovidData {
    @ElementList(name = "items")
    @Path("body")
    public List<Item> itemList;

    List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
