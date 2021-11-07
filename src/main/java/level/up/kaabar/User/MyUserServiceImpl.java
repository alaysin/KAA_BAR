package level.up.kaabar.User;

import level.up.kaabar.config.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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

        ArrayList<User> usersFound = users;
        return usersFound;
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
    public User findBySurName(String surname) {
        return null;
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void run (String... args) throws Exception {


        }


}
