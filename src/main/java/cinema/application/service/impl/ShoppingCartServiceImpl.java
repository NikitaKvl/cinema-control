package cinema.application.service.impl;

import cinema.application.model.MovieSession;
import cinema.application.model.ShoppingCart;
import cinema.application.model.Ticket;
import cinema.application.model.User;
import cinema.application.repository.ShoppingCartRepository;
import cinema.application.service.MovieSessionService;
import cinema.application.service.ShoppingCartService;
import cinema.application.service.TicketService;
import cinema.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final TicketService ticketService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ShoppingCart shoppingCart = getByUser(user);
        ticketService.save(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.getShoppingCartByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addToCart(Authentication auth, Long movieSessionId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        addSession(movieSession, user);
    }
}
