package be.craftmine.logichain.route.infrastructure.kafka.listener;

import be.craftmine.logichain.route.application.optimizeroute.OptimizeRouteCommand;
import be.craftmine.logichain.route.application.optimizeroute.OptimizeRouteUseCase;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationListener {

    private final OptimizeRouteUseCase optimizeRouteUseCase;

    public RouteOptimizationListener(OptimizeRouteUseCase optimizeRouteUseCase) {
        this.optimizeRouteUseCase = optimizeRouteUseCase;
    }

    @KafkaListener(topics = "shipment-topic", groupId = "route-optimization-group")
    public void onShipmentCreated(ShipmentCreated event) {
        // Optimize route and publish event
        optimizeRouteUseCase.execute(new OptimizeRouteCommand.Builder()
                .withShipmentId(event.getShipmentId())
                .withDeliveryAddress(event.getDeliveryAddress())
                .withProductId(event.getProductId())
                .withStatus(event.getStatus())
                .build());
    }
}
