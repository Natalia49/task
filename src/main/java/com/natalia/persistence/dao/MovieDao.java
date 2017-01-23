package com.natalia.persistence.dao;

import com.natalia.persistence.entity.Movie;

import java.util.List;

public interface MovieDao extends BaseDao<Movie, Long> {

    List<Movie> findMoviesWithoutRating();

    void deleteMovieById(Long id);
}
