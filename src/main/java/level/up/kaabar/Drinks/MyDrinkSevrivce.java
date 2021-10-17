package level.up.kaabar.Drinks;

import org.springframework.stereotype.Component;

@Component
public class MyDrinkSevrivce {
    public Drink newDrinkAdd (String drinkName, String brand, double price, int quantity, String typ) {
        Drink newDrink = new Drink(drinkName, brand, price,quantity, typ);
        return newDrink;
    }
    public Drink takeDate (int id) {



    }

    public Drink updateDrinkQuantity (int id, int quantyty) {

    }
}
