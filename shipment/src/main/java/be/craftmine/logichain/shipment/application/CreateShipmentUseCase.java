package be.craftmine.logichain.shipment.application;

import be.craftmine.logichain.shipment.domain.CreateShipmentCommand;
import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class CreateShipmentUseCase {

    private final ShipmentPublisher publisher;

    public CreateShipmentUseCase(ShipmentPublisher publisher) {
        this.publisher = publisher;
    }

    public void execute(CreateShipmentCommand command) {
        ShipmentCreatedEvent shipmentCreatedEvent = new ShipmentCreatedEvent()
                .withDeliveryAddress(command.getDeliveryAddress())
                .withProductId(command.getProductId().intValue());
        publisher.publish(shipmentCreatedEvent);
    }
}
