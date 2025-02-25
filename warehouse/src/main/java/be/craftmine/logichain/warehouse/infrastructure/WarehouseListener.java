package be.craftmine.logichain.warehouse.infrastructure;

import be.craftmine.logichain.shipment.domain.events.ShipmentCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WarehouseListener {
    @KafkaListener(topics = "shipment-topic", groupId = "warehouse-group")
    public void onShipmentCreated(ShipmentCreatedEvent event) {
        // Update inventory
        updateInventory(event);
    }

    private void updateInventory(ShipmentCreatedEvent event) {
        // Simulate inventory update logic
    }
}
