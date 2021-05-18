package com.bookmyshow.model;

import java.util.List;

public class City {

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private final String id;
    private String name;

    private List<Cinema> cinemas;

    public String getName() {
        return name;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
