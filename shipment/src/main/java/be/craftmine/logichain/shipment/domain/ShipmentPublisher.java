package be.craftmine.logichain.shipment.domain;

import be.craftmine.logichain.shipment.domain.events.ShipmentCreatedEvent;

public interface ShipmentPublisher {
    void publish(ShipmentCreatedEvent shipmentCreatedEvent);
}
