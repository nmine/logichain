package be.craftmine.logichain.route.domain;


public class RouteOptimizedEvent {
    private Long shipmentId;
    private String optimizedRoute;

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getOptimizedRoute() {
        return optimizedRoute;
    }

    public void setOptimizedRoute(String optimizedRoute) {
        this.optimizedRoute = optimizedRoute;
    }
}