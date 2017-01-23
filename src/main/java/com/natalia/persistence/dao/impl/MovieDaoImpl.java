package com.natalia.persistence.dao.impl;

import com.natalia.persistence.dao.MovieDao;
import com.natalia.persistence.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl extends BaseDaoImpl<Movie, Long> implements MovieDao {
    public MovieDaoImpl() {
        super(Movie.class);
    }

    @Override
    public List<Movie> findMoviesWithoutRating() {
        return getEntityManager()
                .createQuery("select n from Movie n where n.id not in (select r.movie.id from Movie m join m.ratings r)", Movie.class)
                .getResultList();
    }
    @Override
    public void deleteMovieById(Long id){
        List<Movie> movies = getEntityManager()
                .createQuery("select m from Movie m where m.id = :id", Movie.class)
                .setParameter("id", id)
                .getResultList();
        movies.forEach(e -> getEntityManager().remove(e));
    }

}
