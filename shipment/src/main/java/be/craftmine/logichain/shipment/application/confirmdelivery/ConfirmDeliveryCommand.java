package be.craftmine.logichain.shipment.application.confirmdelivery;

public class ConfirmDeliveryCommand {
    private final Integer shipmentId;

    public ConfirmDeliveryCommand(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }
}
