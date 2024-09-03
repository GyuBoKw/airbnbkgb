package airbnbkgb.domain;

import airbnbkgb.domain.*;
import airbnbkgb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentDenied extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long reservationId;
    private Float price;

    public PaymentDenied(Payment aggregate) {
        super(aggregate);
    }

    public PaymentDenied() {
        super();
    }
}
//>>> DDD / Domain Event
