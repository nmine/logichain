package be.craftmine.logichain.route.infrastructure;

import be.craftmine.logichain.route.domain.RouteOptimizedEvent;
import be.craftmine.logichain.route.domain.ShipmentCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationListener {

    private final KafkaTemplate<String, RouteOptimizedEvent> kafkaTemplate;

    public RouteOptimizationListener(KafkaTemplate<String, RouteOptimizedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //    Route Optimization → Carrier Integration (Customer-Supplier)
    //    Customer : Carrier Integration, car il dépend des itinéraires optimisés fournis par Route Optimization.
    @KafkaListener(topics = "shipment-topic", groupId = "route-optimization-group")
    public void onShipmentCreated(ShipmentCreatedEvent event) {
        // Optimize route and publish event
        kafkaTemplate.send("route-topic", new RouteOptimizedEvent());
    }
}
