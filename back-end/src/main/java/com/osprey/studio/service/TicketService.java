package com.osprey.studio.service;

import com.osprey.studio.domain.entities.Ticket;
import com.osprey.studio.repository.TicketRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends AbstractBaseService<Ticket> {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Ticket, Long> getRepository() {
        return repository;
    }
}
