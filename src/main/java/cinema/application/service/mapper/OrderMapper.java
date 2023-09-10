package cinema.application.service.mapper;

import cinema.application.dto.response.OrderResponseDto;
import cinema.application.model.Order;
import cinema.application.model.Ticket;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "tickets", target = "ticketIds", qualifiedByName = "getTicketsIds")
    OrderResponseDto mapToDto(Order order);

    @Named("getTicketsIds")
    static List<Long> getTicketsIds(List<Ticket> tickets) {
        return tickets.stream().map(Ticket::getId).toList();
    }
}
