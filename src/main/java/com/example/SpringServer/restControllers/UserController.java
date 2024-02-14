package com.example.SpringServer.restControllers;


import com.example.SpringServer.ResourceNotFoundException;
import com.example.SpringServer.entity.User;
import com.example.SpringServer.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }
    @PostMapping("/users")
    public User createUser(@ModelAttribute User user) {
        User nUser = userRepository.save(user);
        return nUser;
    }
    @GetMapping("/getUser")
    public ResponseEntity<User> getUserByLogin(@ModelAttribute User user) {
        Iterable<User> users = userRepository.findAll();
        for (User u : users){
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())){
                System.out.println(u.getLogin() + u.getPassword());
                return ResponseEntity.ok(user);
            }
        }
        return (ResponseEntity<User>) ResponseEntity.notFound();
    }
}
