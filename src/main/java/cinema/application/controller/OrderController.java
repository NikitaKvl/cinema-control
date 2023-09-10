package cinema.application.controller;

import cinema.application.dto.response.OrderResponseDto;
import cinema.application.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/complete")
    @Operation(summary = "Complete order")
    public OrderResponseDto completeOrder(Authentication auth) {
        return orderService.completeOrder(auth);
    }

    @GetMapping
    @Operation(summary = "Get order history by user")
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        return orderService.getOrdersHistory(auth);
    }
}
