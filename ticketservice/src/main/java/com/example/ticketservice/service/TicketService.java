package com.example.ticketservice.service;

import com.example.ticketservice.model.Ticket;
import com.example.ticketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final SentimentAnalysisClient sentimentAnalysisClient;

    @Autowired
    public TicketService(TicketRepository ticketRepository, SentimentAnalysisClient sentimentAnalysisClient) {
        this.ticketRepository = ticketRepository;
        this.sentimentAnalysisClient = sentimentAnalysisClient;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        String sentiment = sentimentAnalysisClient.analyzeSentiment(ticket.getDescription());
        System.out.println("Sentiment analysis result: " + sentiment); 
        ticket.setSentiment(sentiment);
        return ticketRepository.save(ticket);
    }
    

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        if (ticketRepository.existsById(id)) {
            updatedTicket.setId(id);
            return ticketRepository.save(updatedTicket);
        }
        return null;
    }

    public boolean deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
