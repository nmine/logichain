package be.craftmine.logichain.shipment.application.createshipment;

import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class CreateShipmentUseCase {

    private final ShipmentPublisher shipmentPublisher;

    public CreateShipmentUseCase(ShipmentPublisher publisher) {
        this.shipmentPublisher = publisher;
    }

    public void execute(CreateShipmentCommand command) {
        ShipmentCreatedEvent shipmentCreatedEvent = new ShipmentCreatedEvent()
                .withDeliveryAddress(command.getDeliveryAddress())
                .withProductId(command.getProductId().intValue());
        shipmentPublisher.publish(shipmentCreatedEvent);
    }
}
