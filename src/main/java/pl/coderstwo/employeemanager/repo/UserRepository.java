package pl.coderstwo.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderstwo.employeemanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
