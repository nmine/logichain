package be.craftmine.logichain.route.application;

import be.craftmine.logichain.route.domain.OptimizeRouteCommand;
import be.craftmine.logichain.route.domain.RouteEventPublisher;
import be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;
import org.springframework.stereotype.Service;

@Service
public class OptimizeRouteUseCase {

    private final RouteEventPublisher routeEventPublisher;

    public OptimizeRouteUseCase(RouteEventPublisher routeEventPublisher) {
        this.routeEventPublisher = routeEventPublisher;
    }

    public void execute(OptimizeRouteCommand event) {
        RouteOptimizedEvent routeEvent = new RouteOptimizedEvent()
                .withShipmentId(event.getShipmentId())
                .withOptimizedRoute("OptimizedRouteDetails");
        routeEventPublisher.publish(routeEvent);
    }
}
