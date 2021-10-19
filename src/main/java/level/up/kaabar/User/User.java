package level.up.kaabar.User;

import lombok.Setter;

import javax.persistence.Id;

public class User {
    @Id
    private int id;
    private String login;
    private String password;
    private boolean isAdmin;
    private String name;
    private String surname;
    @Setter
    private boolean toDelete;

    public User(String login, String password, boolean isAdmin, String name, String surname) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.name = name;
        this.surname = surname;
    }

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
