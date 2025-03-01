package be.craftmine.logichain.shipment.application;

import be.craftmine.logichain.shipment.domain.ShipmentRepository;
import be.craftmine.logichain.shipment.domain.ShipmentStatus;
import org.springframework.stereotype.Service;

@Service
public class ConfirmDeliveryUseCase {
    private ShipmentRepository shipmentRepository;

    public void execute(ConfirmDeliveryCommand confirmDeliveryCommand) {
        shipmentRepository.updateShipmentStatus(1, ShipmentStatus.DELIVERED);
    }
}
