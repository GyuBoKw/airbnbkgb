package airbnbkgb.infra;

import airbnbkgb.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RoomHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Room>> {

    @Override
    public EntityModel<Room> process(EntityModel<Room> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deleteroom")
                .withRel("deleteroom")
        );

        return model;
    }
}
