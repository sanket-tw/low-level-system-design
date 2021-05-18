package com.bookmyshow.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Movie {

    enum Genre {
        ROM_COM, COMEDY, SCI_FI, THRILLER, HORROR
    }

    private String movieId;
    private String name;
    private String description;
    private String movieTrailerUrl;
    private Date releaseDate;
    private int runTime;

    private List<String> languages;

    private Genre genre;

    private Set<String> searchTags;

    //further
    Map<String, List<Show>> cityShowMap;
}
