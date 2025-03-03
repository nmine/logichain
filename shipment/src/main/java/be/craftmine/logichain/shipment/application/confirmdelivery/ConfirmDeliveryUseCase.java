package be.craftmine.logichain.shipment.application.confirmdelivery;

import be.craftmine.logichain.shipment.domain.ShipmentRepository;
import be.craftmine.logichain.shipment.domain.ShipmentStatus;
import org.springframework.stereotype.Service;

@Service
public class ConfirmDeliveryUseCase {
    private final ShipmentRepository shipmentRepository;

    public ConfirmDeliveryUseCase(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void execute(ConfirmDeliveryCommand confirmDeliveryCommand) {
        shipmentRepository.updateShipmentStatus(1, ShipmentStatus.DELIVERED);
    }
}
