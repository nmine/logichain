package be.craftmine.logichain.carrier.domain;

public interface CarrierPublisher {
    public void publish(DeliveryConfirmedEvent deliverShipmentCommand);
}
