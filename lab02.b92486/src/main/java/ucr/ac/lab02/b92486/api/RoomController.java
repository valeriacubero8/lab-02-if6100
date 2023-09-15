package ucr.ac.lab02.b92486.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.lab02.b92486.handlers.NewRoomHandler;
import ucr.ac.lab02.b92486.handlers.NewUserHandler;

import java.util.UUID;


@RestController
public class RoomController {
    @Autowired
    NewRoomHandler handlerRoom;

    @Autowired
    NewUserHandler handlerUser;

    @PostMapping("/room/create")
    public String create(@RequestBody RoomCreateRequest payload){

        try{
            UUID id = UUID.randomUUID();

            handlerRoom.handle(new NewRoomHandler.Command(
                    id, payload.roomName(), payload.createdBy()
            ));

            handlerUser.handle( new NewUserHandler.Command(
                    id, payload.createdBy()
            ));

            return "The room id is: " + id;
        }catch (Exception ex){
            return "The room cant be created";
        }


    }
}

record RoomCreateRequest(String roomName, String createdBy){ }