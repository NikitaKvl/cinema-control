package cinema.application.repository;

import cinema.application.model.Movie;
import cinema.application.model.MovieSession;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {
    List<MovieSession> findMovieSessionByMovieAndShowTimeBetween(Movie movie,
                                                                 LocalDateTime showTime,
                                                                 LocalDateTime showTime2);
}
