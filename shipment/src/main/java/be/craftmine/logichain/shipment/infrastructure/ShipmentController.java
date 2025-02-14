package be.craftmine.logichain.shipment.infrastructure;

import be.craftmine.logichain.shipment.domain.Shipment;
import be.craftmine.logichain.shipment.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody String request) {
        Shipment shipment = shipmentService.createShipment(request);
        return ResponseEntity.ok(shipment);
    }
}
