package cinema.application.service.impl;

import cinema.application.model.Ticket;
import cinema.application.repository.TicketRepository;
import cinema.application.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
