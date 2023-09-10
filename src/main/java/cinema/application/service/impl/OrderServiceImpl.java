package cinema.application.service.impl;

import cinema.application.dto.response.OrderResponseDto;
import cinema.application.model.Order;
import cinema.application.model.ShoppingCart;
import cinema.application.model.User;
import cinema.application.repository.OrderRepository;
import cinema.application.service.OrderService;
import cinema.application.service.ShoppingCartService;
import cinema.application.service.UserService;
import cinema.application.service.mapper.OrderMapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private static OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @Override
    public OrderResponseDto completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        ShoppingCart cart = shoppingCartService.getByUser(user);
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setUser(user);
        order.setTickets(List.copyOf(cart.getTickets()));
        orderRepository.save(order);
        shoppingCartService.clear(cart);
        return orderMapper.mapToDto(order);
    }

    @Override
    public List<OrderResponseDto> getOrdersHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return orderRepository.findAllByUser(user).stream().map(orderMapper::mapToDto).toList();
    }
}
