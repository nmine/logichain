package be.craftmine.logichain.shipment.infrastructure.kafka;

import be.craftmine.logichain.shipment.domain.ShipmentEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaShipmentEventRepository implements ShipmentEventRepository {

    @Override
    public List<Object> getEventsForShipment(Integer shipmentId) {
        return null;
    }
}
