package be.craftmine.logichain.route.domain;
import  be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;
public interface RouteEventPublisher {
    void publish(RouteOptimizedEvent event);
}
