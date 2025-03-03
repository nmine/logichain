package be.craftmine.logichain.carrier.domain;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

public interface DeliverRoutePublisher {
    public void publish(DeliveryConfirmedEvent deliverShipmentCommand);
}
