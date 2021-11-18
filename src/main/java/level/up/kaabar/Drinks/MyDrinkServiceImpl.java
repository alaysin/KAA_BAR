package level.up.kaabar.Drinks;

import level.up.kaabar.model.Drink;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyDrinkServiceImpl implements MyDrinkSevrvice {

    private ArrayList<Drink> drinks = new ArrayList<>();

    @Override
    public Drink newDrinkAdd (String drinkName, String brand, int price, int quantity, String typ) {
        Drink newDrink = new Drink(drinkName, brand, price, quantity, typ);
        return newDrink;
    }

    @Override
    public Drink findByID (int id) {
        return drinks.get(id);

    }

    @Override
    public Drink updateDrinkQuantity (int id, int quantyty, Drink drink) {
        if (drinks.size()<= id && id<=0){
        return drink;

        }
        drinks.get(id).setQuantity(quantyty);

        return drinks.get(id);
    }

    @Override
    public List<Drink> findAll() {
        ArrayList<Drink> drinksFound = drinks;

        return drinksFound;
    }
}
