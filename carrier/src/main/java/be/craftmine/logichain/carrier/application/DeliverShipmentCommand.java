package be.craftmine.logichain.carrier.application;

import be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;

public class DeliverShipmentCommand extends RouteOptimizedEvent {
    public DeliverShipmentCommand(Integer shipmentId) {
        super();
    }
}
