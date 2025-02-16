package be.craftmine.logichain.shipment.service;

import be.craftmine.logichain.sharedkernel.domain.ShipmentCreatedEvent;
import be.craftmine.logichain.shipment.domain.Shipment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    private final KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate;

    public ShipmentService(KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Shipment createShipment(String request) {
        Shipment shipment = new Shipment();
        ShipmentCreatedEvent event = new ShipmentCreatedEvent();
        event.setShipmentId(1L);
        event.setDeliveryAddress("event");
        event.setProductId(1L);
        kafkaTemplate.send("shipment-topic", event);
        return shipment;
    }
}
