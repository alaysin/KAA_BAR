package level.up.kaabar.controllers;

import level.up.kaabar.Drinks.MyDrinkServiceImpl;
import level.up.kaabar.dao.DrinksRepo;
import level.up.kaabar.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/drinks")
public class MyDrinkController {

    private DrinksRepo drinksRepo;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam(defaultValue = "10") int count) {
        model.addAttribute("drinks", drinksRepo.findAll()
        .stream().collect(Collectors.toList()));

        return "drinks";
    }

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
    public @ResponseBody Drink newDrinkAdd (@RequestBody String drinkName, String brand, int price, int quantity, String typ) {
        return myDrinkServiceImpl.newDrinkAdd(drinkName, brand, price, quantity, typ);
    }
    @PutMapping("/{id}/{q}")
    public @ResponseBody Drink updateDrinkQuantity(@PathVariable("id") int id,
                                                   @PathVariable ("q") int quantyty,
                                                   @RequestBody Drink drink) {
        return updateDrinkQuantity(id, quantyty,drink);
    }

}
