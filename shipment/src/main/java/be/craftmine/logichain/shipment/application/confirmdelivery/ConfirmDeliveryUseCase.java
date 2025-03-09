package be.craftmine.logichain.shipment.application.confirmdelivery;

import be.craftmine.logichain.shipment.domain.Shipment;
import be.craftmine.logichain.shipment.domain.ShipmentEventRepository;
import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.events.ShipmentDeliveryConfirmed;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmDeliveryUseCase {
    private final ShipmentPublisher shipmentPublisher;
    private final ShipmentEventRepository shipmentEventRepository;

    public ConfirmDeliveryUseCase(ShipmentPublisher shipmentPublisher, ShipmentEventRepository shipmentEventRepository) {
        this.shipmentPublisher = shipmentPublisher;
        this.shipmentEventRepository = shipmentEventRepository;
    }


    public void execute(ConfirmDeliveryCommand confirmDeliveryCommand) {
        List<Object> eventsForShipment = shipmentEventRepository.getEventsForShipment(confirmDeliveryCommand.getShipmentId());
        Shipment shipment = Shipment.rebuildFromEvents(eventsForShipment);
        shipmentPublisher.publish(
                new ShipmentDeliveryConfirmed().withShipmentId(confirmDeliveryCommand.getShipmentId())
        );
    }
}
