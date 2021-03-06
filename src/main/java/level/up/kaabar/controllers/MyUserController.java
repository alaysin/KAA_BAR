package level.up.kaabar.controllers;


import level.up.kaabar.User.MyUserServiceImpl;
import level.up.kaabar.dao.UserRepoPaging;
import level.up.kaabar.model.User;
import level.up.kaabar.utils.PaginationParams;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@Controller
@RequestMapping ("/users")
@AllArgsConstructor
public class MyUserController {

    private UserRepoPaging userRepoPaging;

    @GetMapping("")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(value = "q", required = false, defaultValue = "") String query,
                        Model model) {

        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        String queryString = query.trim();

        Page<User> users = hasText(queryString) ?
                userRepoPaging.findContact(queryString, pageRequest)
                : userRepoPaging.findAll(pageRequest);

        model.addAttribute("query", query);

        model.addAttribute("users", users.stream().collect(Collectors.toList()));

        PaginationParams<User> paginationParams = new PaginationParams<>(users);
        model.addAllAttributes(paginationParams.getParams(page));

        return "users";
    }

    @PostMapping
    @Transactional
    public @ResponseBody String create(@RequestParam("login") String login,
                                       @RequestParam("name") String name,
                                       @RequestParam("last_name") String last_name,
                                       @RequestParam("password") String password
    ) {
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setLast_name(last_name);
        user.setPassword(password);
        user.setAdmin(false);
        user.setToDelete(false);

        userRepoPaging.save(user);

        return "OK";
    }


    /*
    @GetMapping
    public String index() {
        return "src/main/resources/templates/users.html";
    }

    @Autowired
    MyUserServiceImpl myUserServiceImpl;
*/


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
