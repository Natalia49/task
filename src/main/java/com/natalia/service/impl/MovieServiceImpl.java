package com.natalia.service.impl;

import com.natalia.persistence.dao.MovieDao;
import com.natalia.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.natalia.persistence.entity.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> findAll() {
        List<Movie> users = movieDao.findAll();
        return users;
    }
    @Override
    public List<Movie> saveMovie(String title, String director) {
        movieDao.save(new Movie(title, director));
        return findAll();
    }
    @Override
    public List<Movie> findMovieWithoutRating() {
        List<Movie> movies = movieDao.findMoviesWithoutRating();
        return movies;
    }
    @Override
    public List<Movie> deleteMovieById(Long id) {
        movieDao.deleteMovieById(id);
        return findAll();
    }

}
