package com.natalia.persistence.dao;

import com.natalia.persistence.entity.Rating;

import java.util.List;


public interface RatingDao extends BaseDao<Rating, Long> {

    List<Rating> findMovieWithoutDate();

    List<Rating> findByRating( Integer first, Integer second);
}
