package com.natalia.persistence.dao.impl;

import com.natalia.persistence.dao.RatingDao;
import com.natalia.persistence.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingDaoImpl extends BaseDaoImpl<Rating, Long> implements RatingDao {
    public RatingDaoImpl() {
        super(Rating.class);
    }

    @Override
    public List<Rating> findMovieWithoutDate(){
        return getEntityManager()
                .createQuery("select r from Rating r where r.date is null", Rating.class)
                .getResultList();
    }
    @Override
    public List<Rating> findByRating( Integer first, Integer second) {
        return getEntityManager()
                .createQuery("select r from Rating r where r.rating between :first and :second order by r.date", Rating.class)
                .setParameter("first", first)
                .setParameter("second", second)
                .getResultList();
    }

}
