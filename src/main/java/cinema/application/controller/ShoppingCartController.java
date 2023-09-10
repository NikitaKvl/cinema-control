package cinema.application.controller;

import cinema.application.dto.response.ShoppingCartResponseDto;
import cinema.application.model.User;
import cinema.application.service.ShoppingCartService;
import cinema.application.service.UserService;
import cinema.application.service.mapper.ShoppingCartMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @PutMapping("/movie-sessions")
    @Operation(summary = "Add movie session to shopping cart")
    public void addToCart(Authentication auth, @RequestParam Long movieSessionId) {
        shoppingCartService.addToCart(auth, movieSessionId);
    }

    @GetMapping("/by-user")
    @Operation(summary = "Get shopping cart by user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).orElseThrow(
                () -> new RuntimeException("User with email "
                        + details.getUsername() + " not found"));
        return ShoppingCartMapper.INSTANCE.mapToDto(shoppingCartService.getByUser(user));
    }
}
