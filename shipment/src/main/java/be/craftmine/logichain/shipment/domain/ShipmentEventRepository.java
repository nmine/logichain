package be.craftmine.logichain.shipment.domain;

import java.util.List;

public interface ShipmentEventRepository {
    List<Object> getEventsForShipment(Integer shipmentId);
}
