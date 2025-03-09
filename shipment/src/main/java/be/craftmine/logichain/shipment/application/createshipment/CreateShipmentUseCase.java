package be.craftmine.logichain.shipment.application.createshipment;

import be.craftmine.logichain.shipment.domain.Shipment;
import be.craftmine.logichain.shipment.domain.ShipmentFactory;
import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.ShipmentRepository;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreated;
import org.springframework.stereotype.Service;

@Service
public class CreateShipmentUseCase {

    private final ShipmentPublisher shipmentPublisher;
    private final ShipmentRepository shipmentRepository;

    public CreateShipmentUseCase(ShipmentPublisher publisher, ShipmentRepository shipmentRepository) {
        this.shipmentPublisher = publisher;
        this.shipmentRepository = shipmentRepository;
    }

    public void execute(CreateShipmentCommand command) {
        Shipment shipment = ShipmentFactory.createShipment(command.getDeliveryAddress(), command.getProductId());
        shipmentRepository.save(shipment);
        ShipmentCreated shipmentCreatedEvent = new ShipmentCreated()
                .withDeliveryAddress(shipment.getDeliveryAddress())
                .withProductId(shipment.getProductId().intValue());
        shipmentPublisher.publish(shipmentCreatedEvent);
    }
}
