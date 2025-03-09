package be.craftmine.logichain.shipment.infrastructure.jpa;

import be.craftmine.logichain.shipment.domain.Shipment;
import be.craftmine.logichain.shipment.domain.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class JpaShipmentRepository implements ShipmentRepository {


    @Override
    public void save(Shipment shipment) {
        // Save shipment to database
    }

    @Override
    public Shipment findById(Integer id) {
        return null;
    }
}
