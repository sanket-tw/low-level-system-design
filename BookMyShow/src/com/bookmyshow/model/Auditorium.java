package com.bookmyshow.model;

import java.util.ArrayList;
import java.util.List;

public class Auditorium {

    public Auditorium(String id, String name, int totalSeats) {
        this.id = id;
        this.name = name;
        this.shows = new ArrayList<>();
        this.totalSeats = totalSeats;
    }

    private String id;
    private String name;

    private int totalSeats;

    private List<Show> shows;
}
