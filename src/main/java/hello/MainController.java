package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.User;
import hello.UserRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/app")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        this.userRepository.save(user);
        return "Saved Ok!";
    }

    @PostMapping(path="/create")
    public @ResponseBody String createUser(@RequestBody User user) {
        this.userRepository.save(user);
        return "Got Data!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
