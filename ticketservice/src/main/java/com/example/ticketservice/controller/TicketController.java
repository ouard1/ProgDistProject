package com.example.ticketservice.controller;
import com.example.ticketservice.service.SentimentAnalysisClient;
import com.example.ticketservice.model.Ticket;
import com.example.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final SentimentAnalysisClient sentimentAnalysisClient;
    
    @Autowired
    public TicketController(TicketService ticketService, SentimentAnalysisClient sentimentAnalysisClient) {
        this.ticketService = ticketService;
        this.sentimentAnalysisClient = sentimentAnalysisClient;
    }


    @GetMapping("/sentiment/{text}")
    public String getSentiment(@PathVariable String text) {
        return sentimentAnalysisClient.analyzeSentiment(text);
    }
    // Récupérer tous les tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Récupérer un ticket par ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un ticket
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket created = ticketService.createTicket(ticket);
        return ResponseEntity.ok(created);
    }

    // Mettre à jour un ticket
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        Ticket ticket = ticketService.updateTicket(id, updatedTicket);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        boolean deleted = ticketService.deleteTicket(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
