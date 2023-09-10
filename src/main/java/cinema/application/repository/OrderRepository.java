package cinema.application.repository;

import cinema.application.model.Order;
import cinema.application.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT DISTINCT o FROM Order o "
            + "join fetch o.tickets t "
            + "join fetch t.movieSession ms "
            + "join fetch ms.cinemaHall "
            + "join fetch ms.movie WHERE o.user = :user")
    List<Order> findAllByUser(User user);
}
