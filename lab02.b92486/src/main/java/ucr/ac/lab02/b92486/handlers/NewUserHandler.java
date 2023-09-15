package ucr.ac.lab02.b92486.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.lab02.b92486.jpa.RoomEntity;
import ucr.ac.lab02.b92486.jpa.UserEntity;
import ucr.ac.lab02.b92486.jpa.repositories.RoomRepository;
import ucr.ac.lab02.b92486.jpa.repositories.UserRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Component
public class NewUserHandler {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;

    public record Command(UUID id, String userName)
    {
        UserEntity toEntity(){
            UserEntity user = new UserEntity();
            user.setId(UUID.randomUUID());
            user.setUserName(userName());
            user.setRoomId(id());
            return user;
        }
    }

    public void handle(Command command){
        userRepository.save(command.toEntity());
    }

    public LinkedHashMap<String, Object> joinHandle(Command command) {
        try {
            UUID room_id = command.toEntity().getRoomId();
            userRepository.save(command.toEntity());

            RoomEntity chatRoom = new RoomEntity();
            chatRoom = roomRepository.findById(room_id).orElse(null);
            List<UserEntity> users = userRepository.findByRoomId(room_id);

            List<String> names = new ArrayList<>();
            for (UserEntity u : users) {
                names.add(u.getUserName());
            }

            LinkedHashMap<String, Object> salaInfo = new LinkedHashMap<>();
            salaInfo.put("id", room_id);
            salaInfo.put("name", chatRoom.getRoomName());
            salaInfo.put("users", names);
            return salaInfo;

        } catch (Exception e) {
            return null;
        }
    }
}
