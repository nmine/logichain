package be.craftmine.logichain.shipment.infrastructure.kafka;

import be.craftmine.logichain.carrier.domain.events.DeliveryConfirmedEvent;
import be.craftmine.logichain.shipment.application.ConfirmDeliveryCommand;
import be.craftmine.logichain.shipment.application.ConfirmDeliveryUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryListener {


    private ConfirmDeliveryUseCase confirmDeliveryUseCase;

    public DeliveryListener(ConfirmDeliveryUseCase confirmDeliveryUseCase) {
        this.confirmDeliveryUseCase = confirmDeliveryUseCase;
    }

    @KafkaListener(topics = "delivery-events", groupId = "shipment-group")
    public void onDeliveryConfirmed(DeliveryConfirmedEvent event) {
        confirmDeliveryUseCase.execute(
                new ConfirmDeliveryCommand(event.getShipmentId())
        );
    }
}
