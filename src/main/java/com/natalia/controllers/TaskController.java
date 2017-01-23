package com.natalia.controllers;

import com.natalia.persistence.entity.Movie;
import com.natalia.persistence.entity.Rating;
import com.natalia.persistence.entity.User;
import com.natalia.service.MovieService;
import com.natalia.service.RatingService;
import com.natalia.service.UserService;
import com.natalia.service.dto.RateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @RequestMapping(value = "/showMovies", method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return movieService.findAll();
    }

    @RequestMapping(value = "/showRatings", method = RequestMethod.GET)
    public List<Rating> getAllRatings(){
        return ratingService.findAll();
    }

    @RequestMapping(value = "/changeDates", method = RequestMethod.PUT)
    public List<Rating> changeDate(){return ratingService.changeDateOfRating();}

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public List<Movie> insertMovie(@RequestParam String title, @RequestParam String director) {
        if(director.equals("undefined")) director=null;
        return movieService.saveMovie(title, director);
    }

    @RequestMapping(value = "/findByRate", method = RequestMethod.GET)
    public List<Rating> findMovieByRate(@RequestParam Integer first, @RequestParam Integer second) {
        return ratingService.findMovieByRating(first, second);
    }

    @RequestMapping(value = "/findWithoutRate", method = RequestMethod.GET)
    public List<Movie> findMovieWiyhoutRate() {
        return movieService.findMovieWithoutRating();
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public List<Movie> deleteMovie(@RequestParam Long movie) {
        return movieService.deleteMovieById(movie);
    }

    @RequestMapping(value = "/showRates", method = RequestMethod.GET)
    public List<RateDto> getAllRates() {
        List<RateDto> rates =  ratingService.getAllRates();
        for(RateDto rate : rates) {
            System.out.println(rate);
        }
        return rates;
    }

}
