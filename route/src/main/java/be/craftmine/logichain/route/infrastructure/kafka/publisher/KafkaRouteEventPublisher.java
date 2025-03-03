package be.craftmine.logichain.route.infrastructure.kafka.publisher;

import be.craftmine.logichain.route.domain.RouteEventPublisher;
import be.craftmine.logichain.route.domain.events.RouteOptimizedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaRouteEventPublisher implements RouteEventPublisher {

    private final KafkaTemplate kafkaTemplate;

    public KafkaRouteEventPublisher(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(RouteOptimizedEvent routeOptimizedEvent) {
        kafkaTemplate.send("route-topic", routeOptimizedEvent);
    }
}
