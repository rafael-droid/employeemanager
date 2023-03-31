package pl.coderstwo.employeemanager.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.coderstwo.employeemanager.model.User;
import pl.coderstwo.employeemanager.repo.UserRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Service
@RequestMapping("/user")
public class UserService {
    @Autowired
    UserRepository userRepository;
    ObjectMapper objectMapper;

    @GetMapping("/")
    public ResponseEntity getUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    };
    @PostMapping("/")
    public ResponseEntity addUser(@RequestBody User user){
        List<User> usersFromDB = userRepository.findByUsername(user.getUsername());

        if(!usersFromDB.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }else {
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        }
    }
}
