package be.craftmine.logichain.shipment.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "processed_events")
public class ProcessedEvent {

    @Id
    private Long aggregateId;
    private Long lastProcessedEventId;

}
