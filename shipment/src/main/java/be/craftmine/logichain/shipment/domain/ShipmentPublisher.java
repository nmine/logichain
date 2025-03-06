package be.craftmine.logichain.shipment.domain;

import be.craftmine.logichain.shipment.domain.events.ShipmentCreated;
import be.craftmine.logichain.shipment.domain.events.ShipmentDeliveryConfirmed;

public interface ShipmentPublisher {
    void publish(ShipmentCreated shipmentCreated);

    void publish(ShipmentDeliveryConfirmed shipmentDeliveryConfirmed);
}
