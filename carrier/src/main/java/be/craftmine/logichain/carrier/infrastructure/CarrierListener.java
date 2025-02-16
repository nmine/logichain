package be.craftmine.logichain.carrier.infrastructure;

import be.craftmine.logichain.sharedkernel.domain.ShipmentCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarrierListener {
    @KafkaListener(topics = "shipment-topic", groupId = "carrier-group")
    public void onShipmentCreated(ShipmentCreatedEvent event) {
        // Integrate with carrier APIs
    }
}
