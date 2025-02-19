package be.craftmine.logichain.sharedkernel.domain;


public class RouteOptimizedEvent {
    private Long shipmentId;
    private String optimizedRoute;

    public RouteOptimizedEvent(Long shipmentId, String optimizedRouteDetails) {
        this.shipmentId = shipmentId;
        this.optimizedRoute = optimizedRouteDetails;
    }

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