package be.craftmine.logichain.carrier.infrastructure.kafka;

import be.craftmine.logichain.carrier.domain.DeliverRoutePublisher;
import be.craftmine.logichain.carrier.domain.DeliveryConfirmedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeliverRoutePublisherKafka implements DeliverRoutePublisher {
    private KafkaTemplate kafkaTemplate;

    public DeliverRoutePublisherKafka(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DeliveryConfirmedEvent deliverShipmentCommand) {
        kafkaTemplate.send("shipment-topic", deliverShipmentCommand);
    }
}
