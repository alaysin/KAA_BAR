package level.up.kaabar.User;

import level.up.kaabar.Drinks.Drink;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserServiceImpl implements MyUserService {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public User createNewUser(String login, String password, String name, String surname) {
        User newUser = new User(login, password, name, surname);
        return newUser;
    }

    @Override
    public User creteNewManager(String login, String password, boolean isAdmin, String name, String surname) {
        User newUser = new User(login, password,isAdmin, name, surname);
        return newUser;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void updatetoAdmin(int id) {

    }
}
