package be.craftmine.logichain.warehouse.application;

import be.craftmine.logichain.shipment.domain.events.ShipmentDeliveryConfirmed;

public class UpdateStockCommand {
    private final Integer shipmentId;

    public UpdateStockCommand(Integer shipmentId) {

        this.shipmentId = shipmentId;
    }
}
