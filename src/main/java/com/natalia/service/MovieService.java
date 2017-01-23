package com.natalia.service;

import com.natalia.persistence.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    List<Movie> saveMovie(String title, String director);

    List<Movie> findMovieWithoutRating();

    List<Movie> deleteMovieById(Long id);
}
