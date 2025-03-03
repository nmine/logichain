package be.craftmine.logichain.route.application.optimizeroute;

public class OptimizeRouteCommand {
    private Integer shipmentId;
    private String deliveryAddress;
    private Integer productId;
    private String status;

    private OptimizeRouteCommand(Builder builder) {
        this.shipmentId = builder.shipmentId;
        this.deliveryAddress = builder.deliveryAddress;
        this.productId = builder.productId;
        this.status = builder.status;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private Integer shipmentId;
        private String deliveryAddress;
        private Integer productId;
        private String status;

        public Builder withShipmentId(Integer shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public Builder withDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder withProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public OptimizeRouteCommand build() {
            return new OptimizeRouteCommand(this);
        }
    }
}