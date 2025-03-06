package be.craftmine.logichain.warehouse.application;

import be.craftmine.logichain.warehouse.domain.WarehousePublisher;
import be.craftmine.logichain.warehouse.domain.events.WarehouseStockReleased;
import org.springframework.stereotype.Service;

@Service
public class UpdateStockUseCase {

    private final WarehousePublisher warehousePublisher;

    public UpdateStockUseCase(WarehousePublisher warehousePublisher) {
        this.warehousePublisher = warehousePublisher;
    }

    public void execute(UpdateStockCommand updateStockCommand) {
        //update stock
        warehousePublisher.publish(new WarehouseStockReleased().withShipmentId(1));
    }
}
