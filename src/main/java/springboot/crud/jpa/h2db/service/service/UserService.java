package springboot.crud.jpa.h2db.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.crud.jpa.h2db.service.entity.User;
import springboot.crud.jpa.h2db.service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
    public List<User> addUsers(List<User> user) {
        return userRepository.saveAll(user);
    }
    public User getUser(int id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else
            return new User();
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User updateUser(User user) {

        User oldUser = null;
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()) {
            oldUser = optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            userRepository.save(oldUser);
        } else {
            return new User();
        }
        return oldUser;
    }
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    public void deleteUsers() {
        userRepository.deleteAll();
    }
}
