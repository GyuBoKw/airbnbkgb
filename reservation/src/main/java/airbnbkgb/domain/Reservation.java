package airbnbkgb.domain;

import airbnbkgb.ReservationApplication;
import airbnbkgb.domain.RoomCancelled;
import airbnbkgb.domain.RoomReserved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private Long roomId;

    private Date date;

    private Float price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        RoomReserved roomReserved = new RoomReserved(this);
        roomReserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        RoomCancelled roomCancelled = new RoomCancelled(this);
        roomCancelled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    //<<< Clean Arch / Port Method
    public void cancelRoom() {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
