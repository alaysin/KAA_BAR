package level.up.kaabar.services;

import level.up.kaabar.model.User;

import java.util.List;

public interface MyUserService{
    public User findById(int id);

    public List findAll();

    public User createNewUser(String login, String password, String name, String surname);

    public User creteNewManager(String login, String password, boolean isAdmin, String name, String surname);

    public User findBySurName(String surname);
}
