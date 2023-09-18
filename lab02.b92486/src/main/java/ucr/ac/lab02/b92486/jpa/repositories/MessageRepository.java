package ucr.ac.lab02.b92486.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.lab02.b92486.jpa.MessageEntity;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {
    List<MessageEntity> findByRoomId(UUID roomId);
}
