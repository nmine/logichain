package be.craftmine.logichain.carrier.infrastructure.kafka;

import be.craftmine.logichain.carrier.application.delivershipment.DeliverShipmentCommand;
import be.craftmine.logichain.carrier.application.delivershipment.DeliverShipmentUsecase;
import be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizedListener {
    private DeliverShipmentUsecase deliverShipmentUsecase;

    public RouteOptimizedListener(DeliverShipmentUsecase deliverShipmentUsecase) {
        this.deliverShipmentUsecase = deliverShipmentUsecase;
    }

    @KafkaListener(topics = "route-topic", groupId = "carrier-group")
    public void onRouteOptimizedEvent(RouteOptimizedEvent event) {
        deliverShipmentUsecase.execute(
                new DeliverShipmentCommand(event.getShipmentId())
        );
    }
}
