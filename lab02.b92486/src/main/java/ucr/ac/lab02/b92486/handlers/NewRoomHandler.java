package ucr.ac.lab02.b92486.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.lab02.b92486.jpa.repositories.RoomRepository;
import ucr.ac.lab02.b92486.jpa.RoomEntity;

import java.util.UUID;

@Component
public class NewRoomHandler {

    @Autowired
    RoomRepository repository;

    public record Command(
            UUID id,
            String roomName,
            String createdBy
    ){
        RoomEntity toEntity(){
            RoomEntity room = new RoomEntity();
            room.setId(UUID.randomUUID());
            room.setRoomName(roomName());
            room.setCreatedBy(createdBy());
            return room;
        }
    }

    public void handle(Command command){

        repository.save(command.toEntity());
    }

}