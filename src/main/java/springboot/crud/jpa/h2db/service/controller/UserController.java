package springboot.crud.jpa.h2db.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.crud.jpa.h2db.service.entity.User;
import springboot.crud.jpa.h2db.service.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/addusers")
    public List<User> addUsers(@RequestBody List<User> user) {
        return userService.addUsers(user);
    }
    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
    @GetMapping("/getusers")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @DeleteMapping("/deleteusers")
    public void deleteUsers() {
        userService.deleteUsers();
    }
}
