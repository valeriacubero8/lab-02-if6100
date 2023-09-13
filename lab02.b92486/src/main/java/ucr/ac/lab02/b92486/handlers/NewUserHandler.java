package ucr.ac.lab02.b92486.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.lab02.b92486.jpa.UserEntity;
import ucr.ac.lab02.b92486.jpa.repositories.UserRepository;

import java.util.UUID;

@Component
public class NewUserHandler {
    @Autowired
    UserRepository repository;

    public record Command(
            UUID id,
            String userName
    ){
        UserEntity toEntity(){
            UserEntity user = new UserEntity();
            user.setId(id());
            user.setUserName(userName());
            return user;
        }
    }

    public void handle(Command command){

        repository.save(command.toEntity());
    }
}
