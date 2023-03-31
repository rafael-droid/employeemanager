package pl.coderstwo.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderstwo.employeemanager.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);

}
