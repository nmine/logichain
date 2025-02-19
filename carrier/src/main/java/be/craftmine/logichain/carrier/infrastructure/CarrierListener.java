package be.craftmine.logichain.carrier.infrastructure;

import be.craftmine.logichain.sharedkernel.domain.RouteOptimizedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarrierListener {
    @KafkaListener(topics = "shipment-topic", groupId = "carrier-group")
    public void onShipmentCreated(RouteOptimizedEvent event) {
        // Integrate with carrier APIs
        integrateWithCarrierAPI(event);
    }

    private void integrateWithCarrierAPI(RouteOptimizedEvent event) {
        // Simulate API call to carrier service
    }
}
