package level.up.kaabar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", allocationSize = 1)
    private int id;

    @Column(unique = true, length = 100)
    @NotBlank
    @Getter
    @Setter
    private String login;

    @Column(unique = false, length = 100)
    @NotBlank
    @Getter
    @Setter
    private String password;

    @Column (name = "is_admin")
    @Getter
    @Setter
    private boolean isAdmin;

    @Column(unique = false, length = 100)
    @NotBlank
    @Getter
    @Setter
    private String name;

    @Column(unique = false, length = 100)
    @NotBlank
    @Getter
    @Setter
    private String last_name;

    @Getter
    @Setter
    @Column (name = "to_delete")
    private boolean toDelete;
/*
    @OneToMany(mappedBy = "manager")
    private List<Drink> drinks = new ArrayList<>();
*/
    public User(String login, String password, boolean isAdmin, String name, String last_name) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.name = name;
        this.last_name = last_name;
    }

    public User(String login, String password, String name, String last_name) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isToDelete() {
        return toDelete;
    }

    public void setToDelete(boolean toDelete) {
        this.toDelete = toDelete;
    }
}
