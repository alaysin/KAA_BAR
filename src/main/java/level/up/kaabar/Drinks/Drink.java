package level.up.kaabar.Drinks;

import lombok.Setter;

import javax.persistence.GeneratedValue;

public class Drink {

    @GeneratedValue
    private int id;

    private String drinkName;

    private String brand;

    private double price;

    @Setter
    private int quantity;

    private String typ;

    public Drink(String drinkName, String brand, double price, int quantity, String typ) {
        this.drinkName = drinkName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.typ = typ;

    }
}
