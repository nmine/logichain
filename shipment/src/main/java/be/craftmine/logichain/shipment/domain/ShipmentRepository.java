package be.craftmine.logichain.shipment.domain;

public interface ShipmentRepository {

    void updateShipmentStatus(Integer shipmentId, ShipmentStatus status);;
}
