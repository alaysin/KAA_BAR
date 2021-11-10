package level.up.kaabar.controllers;

import level.up.kaabar.User.MyUserServiceImpl;
import level.up.kaabar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")
public class MyUserController {

    @GetMapping
    public String index() {
        return "src/main/resources/templates/user.html";
    }

    @Autowired
    MyUserServiceImpl myUserServiceImpl;


/*
    @GetMapping
    public List<User> usersFindAll() {
        return myUserServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody User findById (int id) {
        return myUserServiceImpl.findById(id);
    }

    @PostMapping
    public @ResponseBody User createNewUser(String login,
                                            String password,
                                            String name,
                                            String surname) {
        return myUserServiceImpl.createNewUser(login, password, name, surname);
    }
*/
}
