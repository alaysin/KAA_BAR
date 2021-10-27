package level.up.kaabar.Drinks;

import level.up.kaabar.User.Manager;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class Drink {
    @Id
    @GeneratedValue
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

    @Setter
    @Column
    @ManyToOne
    private Manager manager;

    public Drink(String drinkName, String brand, double price, int quantity, String typ) {
        this.drinkName = drinkName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.typ = typ;

    }

    public Drink(@NotBlank String drinkName, @NotBlank String brand, @NotBlank double price, int quantity, @NotBlank String typ, Manager manager) {
        this.drinkName = drinkName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.typ = typ;
        this.manager = manager;
    }

}
