package cinema.application.repository;

import cinema.application.model.ShoppingCart;
import cinema.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("SELECT DISTINCT sc FROM ShoppingCart sc "
            + "left join fetch sc.tickets t "
            + "left join fetch t.movieSession ms "
            + "left join fetch ms.cinemaHall "
            + "left join fetch ms.movie WHERE sc.user = :user")
    ShoppingCart getShoppingCartByUser(User user);
}
