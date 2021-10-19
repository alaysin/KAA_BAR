package level.up.kaabar.Drinks;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyDrinkSevrvice {
    public Drink newDrinkAdd (String drinkName, String brand, double price, int quantity, String typ);

    public Drink findByID (int id);

    public Drink updateDrinkQuantity (int id, int quantyty, Drink drink);

    public List<Drink> findAll();
}
