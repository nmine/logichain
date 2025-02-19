package be.craftmine.logichain.shipment.service;

import be.craftmine.logichain.sharedkernel.domain.ShipmentCreatedEvent;
import be.craftmine.logichain.shipment.domain.Shipment;
import be.craftmine.logichain.shipment.infrastructure.ShipmentRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShipmentService {
    private final KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate;

    public ShipmentService(KafkaTemplate<String, ShipmentCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Shipment createShipment(ShipmentRequest request) {
        Shipment shipment = new Shipment(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                request.getDeliveryAddress(),
                request.getProductId());
        ShipmentCreatedEvent shipmentCreatedEvent = new ShipmentCreatedEvent(
                shipment.getId(),
                shipment.getDeliveryAddress(),
                shipment.getProductId());
        kafkaTemplate.send("shipment-topic", shipmentCreatedEvent);
        return shipment;
    }
}
