package com.academy.springwebapplication.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "departures")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @OneToMany(mappedBy = "departure", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}