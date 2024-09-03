package airbnbkgb.domain;

import airbnbkgb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RoomEdited extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Float price;
}
