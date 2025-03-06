package be.craftmine.logichain.warehouse.infrastructure.kafka;

import be.craftmine.logichain.shipment.domain.events.ShipmentDeliveryConfirmed;
import be.craftmine.logichain.warehouse.application.UpdateStockCommand;
import be.craftmine.logichain.warehouse.application.UpdateStockUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WarehouseListener {

    private UpdateStockUseCase updateStockUseCase;

    public WarehouseListener(UpdateStockUseCase updateStockUseCase) {
        this.updateStockUseCase = updateStockUseCase;
    }

    @KafkaListener(topics = "shipment-topic", groupId = "warehouse-group")
    public void onShipmentCreated(ShipmentDeliveryConfirmed shipmentDeliveryConfirmed) {
        updateStockUseCase.execute(new UpdateStockCommand(shipmentDeliveryConfirmed.getShipmentId()));
    }
}
