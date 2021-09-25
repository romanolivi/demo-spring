package com.practicespring.practicespring;

import com.practicespring.practicespring.entity.User;
import com.practicespring.practicespring.jparepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private static List<User> users = new ArrayList<>();

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        users = this.userRepository.findAll();
        return users;
    }

    public void deleteUser(Long id) {
         boolean inputUser = this.userRepository.existsById(id);
         if(!inputUser) {
             throw new IllegalStateException("User with id " + id + " does not exist");
         }

         this.userRepository.deleteById(id);
    }

    public void addUser(User user) {
        Optional<User> newUser = this.userRepository.findUserByUsername(user.getUsername());
        if(newUser.isPresent()) {
            throw new IllegalStateException("User already exists in the database");
        }

        this.userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> foundUser = this.userRepository.findById(id);
        if(foundUser.isPresent()) {
            return foundUser;
        }
        return null;
    }


}
