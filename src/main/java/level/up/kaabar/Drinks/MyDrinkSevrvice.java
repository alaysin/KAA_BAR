package level.up.kaabar.Drinks;

import level.up.kaabar.model.Drink;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyDrinkSevrvice {
    public Drink newDrinkAdd (String drinkName, String brand, int price, int quantity, String typ);

    public Drink findByID (int id);

    public Drink updateDrinkQuantity (int id, int quantyty, Drink drink);

    public List<Drink> findAll();
}
