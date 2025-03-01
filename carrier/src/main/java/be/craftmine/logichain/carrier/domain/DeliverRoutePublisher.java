package be.craftmine.logichain.carrier.domain;

import be.craftmine.logichain.carrier.application.DeliveryConfirmedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeliverRoutePublisher {
    private KafkaTemplate kafkaTemplate;

    public DeliverRoutePublisher(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DeliveryConfirmedEvent deliverShipmentCommand) {
        kafkaTemplate.send("shipment-topic", deliverShipmentCommand);
    }
}
