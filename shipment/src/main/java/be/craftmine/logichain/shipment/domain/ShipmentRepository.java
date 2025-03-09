package be.craftmine.logichain.shipment.domain;

public interface ShipmentRepository {

    void save(Shipment shipment);

    Shipment findById(Integer id);
}
