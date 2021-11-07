package level.up.kaabar.Drinks;

import level.up.kaabar.config.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class MyDrinkController {

    @Autowired
    MyDrinkServiceImpl myDrinkServiceImpl;

    @GetMapping
    public @ResponseBody List<Drink> findAll() {
        return  myDrinkServiceImpl.findAll();
    }


    @GetMapping("/{id}")
    public @ResponseBody Drink findByid(@PathVariable("id") int id) {
        return myDrinkServiceImpl.findByID(id);
    }

    @PostMapping
    public @ResponseBody Drink newDrinkAdd (@RequestBody String drinkName, String brand, double price, int quantity, String typ) {
        return myDrinkServiceImpl.newDrinkAdd(drinkName, brand, price, quantity, typ);
    }
    @PutMapping("/{id}/{q}")
    public @ResponseBody Drink updateDrinkQuantity(@PathVariable("id") int id,
                                                   @PathVariable ("q") int quantyty,
                                                   @RequestBody Drink drink) {
        return updateDrinkQuantity(id, quantyty,drink);
    }

}
