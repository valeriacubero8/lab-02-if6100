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
    NewRoomHandler roomHandler;
    NewUserHandler userHandler;

    @PostMapping("/room/create")
    public String create(@RequestBody RoomCreateRequest payload){
        UUID id = UUID.randomUUID();

        roomHandler.handle(new NewRoomHandler.Command(
                id,
                payload.roomName(),
                payload.createdBy()
        ));

        userHandler.handle(new NewUserHandler.Command(
                id,
                payload.createdBy()
        ));

        return "OK";
    }




    @RequestMapping("/echo")
    public String echo(){
        return "Hey there";
    }

}

record RoomCreateRequest(String roomName, String createdBy, String userName){}