package com.practicespring.practicespring;

import com.practicespring.practicespring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    UserRepository userRepository;

    @GetMapping(path="/users")
    public List<User> allUsers() {
        return userService.getUsers();
    }

    @GetMapping(path="/users/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user;
    }

    @PostMapping(path="/users")
    public void addNewUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

//    @PutMapping(path="/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        Optional<User> u = this.userRepository.findById(id);
//
//
//        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
//    }

//    @PostMapping("/users")
//    public ResponseEntity<Void> addUser(@RequestBody User user) {
//        User newUser = this.userRepository.save(user);
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

}


























