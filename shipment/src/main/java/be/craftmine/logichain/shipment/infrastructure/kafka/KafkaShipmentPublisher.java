package be.craftmine.logichain.shipment.infrastructure.kafka;

import be.craftmine.logichain.shipment.domain.ShipmentPublisher;
import be.craftmine.logichain.shipment.domain.events.ShipmentCreated;
import be.craftmine.logichain.shipment.domain.events.ShipmentDeliveryConfirmed;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaShipmentPublisher implements ShipmentPublisher {
    private final KafkaTemplate<String, ShipmentCreated> kafkaTemplateCreated;
    private final KafkaTemplate<String, ShipmentDeliveryConfirmed> kafkaTemplateDelivery;

    public KafkaShipmentPublisher(KafkaTemplate<String, ShipmentCreated> kafkaTemplateCreated, KafkaTemplate<String, ShipmentDeliveryConfirmed> kafkaTemplateDelivery) {
        this.kafkaTemplateCreated = kafkaTemplateCreated;
        this.kafkaTemplateDelivery = kafkaTemplateDelivery;
    }

    @Override
    public void publish(ShipmentCreated shipmentCreated) {
        kafkaTemplateCreated.send("shipment-topic", shipmentCreated);
    }

    @Override
    public void publish(ShipmentDeliveryConfirmed shipmentDeliveryConfirmed) {
        kafkaTemplateDelivery.send("shipment-topic", shipmentDeliveryConfirmed);
    }
}
