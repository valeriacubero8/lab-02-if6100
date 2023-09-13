package ucr.ac.lab02.b92486.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.lab02.b92486.jpa.UserEntity ;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{
}
