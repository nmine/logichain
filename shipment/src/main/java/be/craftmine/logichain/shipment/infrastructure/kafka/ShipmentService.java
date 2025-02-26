package be.craftmine.logichain.shipment.infrastructure.kafka;

import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService implements ShipmentPublisher {
    private final KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate;

    public ShipmentService(KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(ShipmentCreatedEvent shipmentCreatedEvent) {
        kafkaTemplate.send("shipment-topic", shipmentCreatedEvent);
    }
}
