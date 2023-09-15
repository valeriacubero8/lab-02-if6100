package ucr.ac.lab02.b92486.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.lab02.b92486.jpa.MessageEntity;
import ucr.ac.lab02.b92486.jpa.RoomEntity;
import ucr.ac.lab02.b92486.jpa.repositories.MessageRepository;
import ucr.ac.lab02.b92486.jpa.repositories.RoomRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Component
public class SendMessageHandler {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    RoomRepository roomRepository;

    public record Command(UUID roomId,  String alias, String message){
        MessageEntity toEntity(){
            MessageEntity message = new MessageEntity();
            message.setMessageId(UUID.randomUUID());
            message.setRoomId(roomId());
            message.setUserName(alias());
            message.setMessage(message());
            message.setCreatedOn(LocalDateTime.now());
            return message;
        }
    }

    public LinkedHashMap handle(Command command)
    {
        try
        {
            MessageEntity message = command.toEntity();
            messageRepository.save(message);

            LinkedHashMap<String, Object> messageInfo = new LinkedHashMap<>();
            messageInfo.put("id", message.getMessageId());
            messageInfo.put("name", message.getMessage());
            messageInfo.put("createdOn", message.getCreatedOn());
            return messageInfo;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public LinkedHashMap getMessageHandle(UUID roomId)
    {
        try
        {
            RoomEntity chatRoom = roomRepository.findById(roomId).orElse(null);
            List<MessageEntity> messages = messageRepository.findByRoomId(roomId);
            List<LinkedHashMap<String,Object>> totalMessages = new ArrayList<>();
            for(MessageEntity u : messages)
            {
                LinkedHashMap<String, Object> singleMessage = new LinkedHashMap<>();
                singleMessage.put("alias", u.getUserName());
                singleMessage.put("message", u.getMessage());
                singleMessage.put("createdOn", u.getCreatedOn());

                totalMessages.add(singleMessage);
            }

            LinkedHashMap<String, Object> messagesRoom = new LinkedHashMap<>();
            messagesRoom.put("id", roomId);
            messagesRoom.put("name", chatRoom.getRoomName());
            messagesRoom.put("messages", totalMessages);

            return messagesRoom;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}