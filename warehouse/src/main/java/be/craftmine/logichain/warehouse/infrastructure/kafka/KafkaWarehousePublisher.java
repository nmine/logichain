package be.craftmine.logichain.warehouse.infrastructure.kafka;

import be.craftmine.logichain.warehouse.domain.WarehousePublisher;
import be.craftmine.logichain.warehouse.domain.events.WarehouseStockReleased;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaWarehousePublisher implements WarehousePublisher {
    private KafkaTemplate kafkaTemplate;

    public KafkaWarehousePublisher(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(WarehouseStockReleased warehouseStockReleased) {
        kafkaTemplate.send("warehouse-topic", warehouseStockReleased);

    }
}
