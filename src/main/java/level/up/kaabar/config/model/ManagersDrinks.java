package level.up.kaabar.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name ="drinks_managers")
public class ManagersDrinks {

    @Id
    @Getter
    @Setter
    private int id;

    @Column(name = "login")
    @Getter @Setter
    private String login;
}
