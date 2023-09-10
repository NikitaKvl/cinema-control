package cinema.application.service;

import cinema.application.model.MovieSession;
import cinema.application.model.ShoppingCart;
import cinema.application.model.User;
import org.springframework.security.core.Authentication;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);

    void addToCart(Authentication auth, Long movieSessionId);
}
