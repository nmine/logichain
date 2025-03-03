package be.craftmine.logichain.shipment.infrastructure.jpa;

import be.craftmine.logichain.shipment.domain.ShipmentRepository;
import be.craftmine.logichain.shipment.domain.ShipmentStatus;
import org.springframework.stereotype.Service;

@Service
public class ShipmentRepositoryJpa implements ShipmentRepository {
    @Override
    public void updateShipmentStatus(Integer shipmentId, ShipmentStatus status) {

    }
}
