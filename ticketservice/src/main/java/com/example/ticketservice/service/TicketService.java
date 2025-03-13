package com.example.ticketservice.service;

import com.example.ticketservice.model.Ticket;
import com.example.ticketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id).map(existingTicket -> {
            existingTicket.setTitle(updatedTicket.getTitle());
            existingTicket.setDescription(updatedTicket.getDescription());
            existingTicket.setStatus(updatedTicket.getStatus());
            // Les dates de mise à jour sont gérées par les annotations @PreUpdate
            return ticketRepository.save(existingTicket);
        }).orElse(null);
    }

    public boolean deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
