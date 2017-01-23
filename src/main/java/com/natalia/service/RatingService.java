package com.natalia.service;

import com.natalia.persistence.entity.Rating;
import com.natalia.service.dto.RateDto;

import java.util.List;

public interface RatingService {

    List<Rating> findAll();

    List<Rating> changeDateOfRating();

    List<Rating> findMovieByRating(Integer first, Integer second);

    List<RateDto> getAllRates();
}
