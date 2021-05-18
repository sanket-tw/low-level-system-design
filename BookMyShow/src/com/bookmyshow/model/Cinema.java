package com.bookmyshow.model;

import com.bookmyshow.model.data.Address;

import java.util.*;
import java.util.stream.Collectors;

public class Cinema {

    public Cinema(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.auditoriums = new ArrayList<>();
    }

    private String id;
    private String name;
    private Address address;
    private List<Auditorium> auditoriums;

    private Map<Date, List<Movie>> movieSchedule; //could be own class

    public List<Movie> getMovies(Date date) {
        return movieSchedule.get(date);
    }

    public List<Movie> allMoviesPlaying(){
        return movieSchedule.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

}
