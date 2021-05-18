package com.bookmyshow.users.feature;

import com.bookmyshow.model.Cinema;
import com.bookmyshow.model.Movie;

import java.util.List;

public class SearchFeature {

    List<Movie> searchByMovieName(String name, Cinema cinema){
        cinema.allMoviesPlaying().stream().filter(movie -> movie.getName.equaks(cinema));
    }

    List<Movie> searchByMovieGenre(String name){

    }

    List<Movie> searchMovieByLanguage(String name){

    }
}
