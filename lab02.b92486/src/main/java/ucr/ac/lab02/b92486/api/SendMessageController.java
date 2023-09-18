package ucr.ac.lab02.b92486.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.lab02.b92486.handlers.SendMessageHandler;


import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {
    @Autowired
    SendMessageHandler messageHandler;

    @PostMapping("/room/message")
    public Map<String, Object> SendMessage(@RequestBody SendMessageRequest payload){
        try
        {
            return messageHandler.handle(new SendMessageHandler.Command(
                    payload.roomId(),
                    payload.alias(),
                    payload.message()));
        }
        catch (Exception e)
        {
            return null;
        }

    }

    @RequestMapping("/room/message")
    public Map<String, Object> GetMessages(@RequestBody GetMessageRequest payload)
    {
        return messageHandler.getMessageHandle( payload.roomId());
    }
}

record SendMessageRequest(UUID roomId, String alias, String message){ }

record GetMessageRequest(UUID roomId){ }