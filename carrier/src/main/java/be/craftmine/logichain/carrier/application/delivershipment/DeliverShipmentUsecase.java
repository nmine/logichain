package be.craftmine.logichain.carrier.application.delivershipment;

import be.craftmine.logichain.carrier.domain.DeliveryConfirmedEvent;
import be.craftmine.logichain.carrier.domain.CarrierPublisher;
import org.springframework.stereotype.Service;

@Service
public class DeliverShipmentUsecase {

    CarrierPublisher deliverRoutePublisher;

    public void execute(DeliverShipmentCommand deliverShipmentCommand)  {
        // execute delivery
        deliverRoutePublisher.publish(new DeliveryConfirmedEvent(deliverShipmentCommand.getShipmentId()));
    }
}
