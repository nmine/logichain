package be.craftmine.logichain.carrier.application.delivershipment;

import be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;

public class DeliverShipmentCommand  {
    private final Integer shipmentId;

    public DeliverShipmentCommand(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }
}
