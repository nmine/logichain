package be.craftmine.logichain.carrier.application;

import be.craftmine.logichain.carrier.domain.DeliverRoutePublisher;
import org.springframework.stereotype.Service;

@Service
public class DeliverShipmentUsecase {

    DeliverRoutePublisher deliverRoutePublisher;

    public void execute(DeliverShipmentCommand deliverShipmentCommand)  {
        // execute delivery
        deliverRoutePublisher.publish(new DeliveryConfirmedEvent(deliverShipmentCommand.getShipmentId()));
    }
}
