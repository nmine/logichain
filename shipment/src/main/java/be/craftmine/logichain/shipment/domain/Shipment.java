package be.craftmine.logichain.shipment.domain;

import java.util.List;

public class Shipment {
    private Long id;
    private String deliveryAddress;
    private Long productId;

    public Shipment(String deliveryAddress, Long productId) {
        this.deliveryAddress = deliveryAddress;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static Shipment rebuildFromEvents(List<Object> events) {
        return null;
    }


}
