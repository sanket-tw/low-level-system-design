package com.bookmyshow;

import com.bookmyshow.exception.MovieNotSelectedException;
import com.bookmyshow.model.Cinema;
import com.bookmyshow.model.City;
import com.bookmyshow.model.Movie;
import com.bookmyshow.model.Show;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BMSService {

    private List<Cinema> cinemas;

    private List<City> cities;

    public void selectCity(String cityName) {
        City city = cities.stream().filter(c -> c.getName().equals(cityName)).findFirst().get();
        this.cinemas = city.getCinemas();
    }

    private List<Movie> getMovies(Date date) throws MovieNotSelectedException {
        if (cinemas.isEmpty())
            throw new MovieNotSelectedException("Select a city");
        return cinemas.stream().flatMap(cinema -> cinema.getMovies(date).stream()).collect(Collectors.toList());
    }

    private List<Cinema> getCinemas() throws MovieNotSelectedException {
        if (cinemas.isEmpty())
            throw new MovieNotSelectedException("Select a city");
        return cinemas;
    }

    public void bookTicket(Show show) {

    }
}
