package be.craftmine.logichain.warehouse.domain;

import be.craftmine.logichain.warehouse.domain.events.WarehouseStockReleased;

public interface WarehousePublisher {
    void publish(WarehouseStockReleased warehouseStockReleased);
}
