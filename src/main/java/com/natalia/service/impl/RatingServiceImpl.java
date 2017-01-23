package com.natalia.service.impl;

import com.natalia.persistence.dao.RatingDao;
import com.natalia.service.RatingService;
import com.natalia.service.dto.RateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.natalia.persistence.entity.Rating;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingDao ratingDao;

    @Override
    public List<Rating> findAll() {
        List<Rating> ratings = ratingDao.findAll();
        return ratings;
    }
    @Override
    public List<Rating> changeDateOfRating() {
        List<Rating> ratings = ratingDao.findMovieWithoutDate();
        ratings.stream().forEach(e -> e.setDate(new Date()));
        return findAll();
    }
    @Override
    public List<Rating> findMovieByRating(Integer first, Integer second) {
        List<Rating> result = ratingDao.findByRating(first, second);
        return result;
    }
    @Override
    public List<RateDto> getAllRates() {
        List<Rating> ratings = ratingDao.findAll();
        List<RateDto> result = new ArrayList<>();
        for(Rating r : ratings) {
            result.add(new RateDto(r.getUser().getName(),
                    r.getMovie().getTitle(),
                    r.getRating()));
        }
        return result;
    }
}
