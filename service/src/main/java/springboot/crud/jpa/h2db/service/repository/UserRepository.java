package springboot.crud.jpa.h2db.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.crud.jpa.h2db.service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
