package level.up.kaabar.User;

import level.up.kaabar.config.model.User;

import java.util.List;

public interface MyUserService{
    public User findById(int id);

    public List findAll();

    public User createNewUser(String login, String password, String name, String surname);

    public User creteNewManager(String login, String password, boolean isAdmin, String name, String surname);

    public User findBySurName(String surname);
}
