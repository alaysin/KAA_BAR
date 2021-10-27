package level.up.kaabar.User;

import level.up.kaabar.Drinks.Drink;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank
    private String login;

    @Column(nullable = false, unique = false, length = 100)
    @NotBlank
    private String password;

    @Column
    private boolean isAdmin;

    @Column(nullable = false, unique = false, length = 100)
    @NotBlank
    private String name;

    @Column(nullable = false, unique = false, length = 100)
    @NotBlank
    private String surname;

    @Setter
    private boolean toDelete;

    @OneToMany(mappedBy = "manager")
    private List<Drink> drinks;

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
