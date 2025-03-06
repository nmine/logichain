package be.craftmine.logichain.shipment.application.confirmdelivery;

import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.events.ShipmentDeliveryConfirmed;
import org.springframework.stereotype.Service;

@Service
public class ConfirmDeliveryUseCase {
    private final ShipmentPublisher shipmentPublisher;

    public ConfirmDeliveryUseCase(ShipmentPublisher shipmentPublisher) {
        this.shipmentPublisher = shipmentPublisher;
    }


    public void execute(ConfirmDeliveryCommand confirmDeliveryCommand) {
        shipmentPublisher.publish(
                new ShipmentDeliveryConfirmed().withShipmentId(confirmDeliveryCommand.getShipmentId())
        );
    }
}
