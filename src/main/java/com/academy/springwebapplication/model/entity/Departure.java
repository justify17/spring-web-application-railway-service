package com.academy.springwebapplication.model.entity;

import com.academy.springwebapplication.model.StationSchedule;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "train","route", "departureDate","arrivalDate"})
@ToString(of = {"id", "train","route", "departureDate","arrivalDate"})
@NoArgsConstructor
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

    @OneToMany(mappedBy = "departure",cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @Transient
    private List<StationSchedule> stationSchedules = new ArrayList<>();
}
