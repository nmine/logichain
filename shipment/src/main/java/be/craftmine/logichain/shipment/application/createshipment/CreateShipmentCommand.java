package be.craftmine.logichain.shipment.application.createshipment;

public class CreateShipmentCommand {
    private String deliveryAddress;
    private Long productId;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
