package level.up.kaabar.User;

import level.up.kaabar.Drinks.Drink;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
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
/*
    @OneToMany(mappedBy = "manager")
    private List<Drink> drinks;
*/
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

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isToDelete() {
        return toDelete;
    }

    public void setToDelete(boolean toDelete) {
        this.toDelete = toDelete;
    }
}
