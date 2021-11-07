package level.up.kaabar.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table  (name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drink_id_seq")
    @SequenceGenerator(name = "drink_id_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private String drinkName;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private String brand;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private double price;

    @Setter
    @Column(nullable = false, updatable = true, length = 50)
    private int quantity;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private String typ;
/*
    @Setter
    @Column
    //@ManyToOne
    private int managerId;
*/
    @ManyToOne
    @Getter
    @Setter
    private User user;

    public Drink(String drinkName, String brand, double price, int quantity, String typ) {
        this.drinkName = drinkName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.typ = typ;

    }

    public Drink(@NotBlank String drinkName, @NotBlank String brand, @NotBlank double price, int quantity, @NotBlank String typ, User user) {
        this.drinkName = drinkName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.typ = typ;
        this.user = user;
    }

    public Drink() {

    }

}
