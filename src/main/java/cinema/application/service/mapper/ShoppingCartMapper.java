package cinema.application.service.mapper;

import cinema.application.dto.response.ShoppingCartResponseDto;
import cinema.application.model.ShoppingCart;
import cinema.application.model.Ticket;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShoppingCartMapper {
    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "tickets", target = "ticketIds", qualifiedByName = "getTicketsIds")
    ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart);

    @Named("getTicketsIds")
    static List<Long> getTicketsIds(List<Ticket> tickets) {
        return tickets.stream().map(Ticket::getId).toList();
    }
}
