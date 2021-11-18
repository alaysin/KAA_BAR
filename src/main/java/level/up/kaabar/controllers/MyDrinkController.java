package level.up.kaabar.controllers;

import level.up.kaabar.dao.DrinksRepo;
import level.up.kaabar.dao.DrinksRepoPaging;
import level.up.kaabar.model.Drink;
import level.up.kaabar.utils.PaginationParams;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@Controller
@RequestMapping({"/drinks", ""})
@AllArgsConstructor
public class MyDrinkController {

    private DrinksRepo drinksRepo;
    private DrinksRepoPaging drinksRepoPaging;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(value = "q", required = false, defaultValue = "") String query
//                      ,@RequestParam(defaultValue = "10") int count
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        String queryString = query.trim();

        Page<Drink> drinks = hasText(queryString) ?
                drinksRepoPaging.findContact(queryString, pageRequest)
                : drinksRepoPaging.findAll(pageRequest);

//        model.addAttribute("drinks", drinksRepo.findAll()
//        .stream().collect(Collectors.toList()));
        model.addAttribute("query", query);
        model.addAttribute("drinks", drinks.stream().collect(Collectors.toList()));
        model.addAttribute("title", "Lets drink!");

        PaginationParams<Drink> paginationParams = new PaginationParams<>(drinks);
        model.addAllAttributes(paginationParams.getParams(page));

        return "drinks";
    }

    @PostMapping
    @Transactional
    public @ResponseBody String create(@RequestParam("name") String name,
                                       @RequestParam("brand") String brand,
                                       @RequestParam("price") int price,
                                       @RequestParam("quantity") int quantity,
                                       @RequestParam("typ") String typ
    ) {
        Drink drink = new Drink();
        drink.setName(name);
        drink.setBrand(brand);
        drink.setPrice(price);
        drink.setQuantity(quantity);
        drink.setTyp(typ);

        drinksRepoPaging.save(drink);

        return "OK";
    }
/*
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
*/
}
