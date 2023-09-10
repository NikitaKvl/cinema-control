package cinema.application.service;

import cinema.application.dto.response.OrderResponseDto;
import java.util.List;
import org.springframework.security.core.Authentication;

public interface OrderService {
    OrderResponseDto completeOrder(Authentication authentication);

    List<OrderResponseDto> getOrdersHistory(Authentication authentication);
}
