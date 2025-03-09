package be.craftmine.logichain.shipment.domain;

public class ShipmentFactory {

    public static Shipment createShipment(String deliveryAddress, Long productId) {
        //check invarian
        if (deliveryAddress == null || productId == null) {
            throw new IllegalArgumentException("Shipment parameters cannot be null");
        }
        return new Shipment(deliveryAddress, productId);
    }
}
