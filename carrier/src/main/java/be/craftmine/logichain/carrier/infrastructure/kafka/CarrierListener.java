package be.craftmine.logichain.carrier.infrastructure.kafka;

import be.craftmine.logichain.carrier.application.DeliverShipmentCommand;
import be.craftmine.logichain.carrier.application.DeliverShipmentUsecase;
import be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarrierListener {
    private DeliverShipmentUsecase deliverShipmentUsecase;

    public CarrierListener(DeliverShipmentUsecase deliverShipmentUsecase) {
        this.deliverShipmentUsecase = deliverShipmentUsecase;
    }

    @KafkaListener(topics = "shipment-topic", groupId = "carrier-group")
    public void onShipmentCreated(RouteOptimizedEvent event) {
        deliverShipmentUsecase.execute(
                new DeliverShipmentCommand(event.getShipmentId())
        );
    }
}
