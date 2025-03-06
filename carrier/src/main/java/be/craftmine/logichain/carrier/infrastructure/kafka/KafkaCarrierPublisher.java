package be.craftmine.logichain.carrier.infrastructure.kafka;

import be.craftmine.logichain.carrier.domain.CarrierPublisher;
import be.craftmine.logichain.carrier.domain.DeliveryConfirmedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaCarrierPublisher implements CarrierPublisher {
    private KafkaTemplate kafkaTemplate;

    public KafkaCarrierPublisher(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DeliveryConfirmedEvent deliveryConfirmedEvent) {
        kafkaTemplate.send("carrier-topic", deliveryConfirmedEvent);
    }
}


