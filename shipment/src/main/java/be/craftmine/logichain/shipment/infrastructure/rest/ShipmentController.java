package be.craftmine.logichain.shipment.infrastructure.rest;

import be.craftmine.logichain.shipment.application.createshipment.CreateShipmentUseCase;
import be.craftmine.logichain.shipment.application.createshipment.CreateShipmentCommand;
import be.craftmine.logichain.shipment.domain.Shipment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final CreateShipmentUseCase createShipmentUseCase;

    public ShipmentController(CreateShipmentUseCase createShipmentUseCase) {
        this.createShipmentUseCase = createShipmentUseCase;
    }


    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody CreateShipmentCommand command) {
        createShipmentUseCase.execute(command);
        return ResponseEntity.ok().build();
    }
}
