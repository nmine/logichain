package be.craftmine.logichain.route.infrastructure;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreatedEvent;
import  be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;
@Service
public class RouteOptimizationListener {

    private final KafkaTemplate<String, be.craftmine.logichain.route.domain.events.RouteOptimizedEvent> kafkaTemplate;

    public RouteOptimizationListener(KafkaTemplate<String, RouteOptimizedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //    Carrier Integration +Route Optimization →(Customer-Supplier)
    //    Customer : Carrier Integration, car il dépend des itinéraires optimisés fournis par Route Optimization.
    @KafkaListener(topics = "shipment-topic", groupId = "route-optimization-group")
    public void onShipmentCreated(ShipmentCreatedEvent event) {
        // Optimize route and publish event
        RouteOptimizedEvent routeEvent = new RouteOptimizedEvent()
                .withShipmentId(event.getShipmentId())
                .withOptimizedRoute("OptimizedRouteDetails");
        kafkaTemplate.send("route-topic", routeEvent);
    }
}
