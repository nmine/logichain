package be.craftmine.logichain.shipment.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ShipmentCreatedEvent implements Serializable {
    @JsonProperty("shipmentId")
    private Long shipmentId;
    @JsonProperty("deliveryAddress")
    private String deliveryAddress;
    @JsonProperty("productId")
    private Long productId;

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Long getProductId() {
        return productId;
    }
}
