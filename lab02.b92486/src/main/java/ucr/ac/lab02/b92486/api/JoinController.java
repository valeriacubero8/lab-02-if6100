package ucr.ac.lab02.b92486.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.lab02.b92486.handlers.NewUserHandler;
import java.util.Map;
import java.util.UUID;

@RestController
public class JoinController {

    @Autowired
    NewUserHandler userHandler;

    @PostMapping("/room/join")
    public Map<String, Object> JoinRoom(@RequestBody RoomJoinRequest payload){
        try
        {
            return userHandler.joinHandle( new NewUserHandler.Command(
                    payload.roomId(), payload.alias()
            ));
        }
        catch (Exception e)
        {
            return null;
        }

    }

}

record RoomJoinRequest(String alias, UUID roomId){ }