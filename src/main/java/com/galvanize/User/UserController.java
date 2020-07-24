package com.galvanize.User;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<User> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public User create(@RequestBody User lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public User read(@PathVariable Map<String, String> querystring) {
        String strId = querystring.get("id");
        Long id = Long.parseLong(strId);
        Optional<User> user = this.repository.findById(id);

        return user.get();
    }

//    @PatchMapping("/{id}")
//    public User update(@RequestBody User user, @PathVariable Map<String, String> querystring) {
//        User updatedUser = new User();
//
//        String strId = querystring.get("id");
//        Long id = Long.parseLong(strId);
//        Optional<User> userFromRepo = this.repository.findById(id);
//
//        updatedUser.setId(userFromRepo.get().getId());
//        updatedUser.setDeliveredOn(lesson.getDeliveredOn());
//        updatedUser.setTitle(lesson.getTitle());
//
//        return this.repository.save(updatedUser);
//    }

//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Map<String, String> querystring) {
//        String result = "no matches found to delete.";
//        String strId = querystring.get("id");
//        Long id = Long.parseLong(strId);
//        Optional<User> user = this.repository.findById(id);
//
//        if (user.toString() != "Optional.empty") {
//            this.repository.delete(user.get());
//            result = "The user with id " + strId + " has been deleted.";
//        }
//
//        return result;
//    }

}
