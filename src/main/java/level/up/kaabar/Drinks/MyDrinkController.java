package level.up.kaabar.Drinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/drinks")
public class MyDrinkController {

    @Autowired
    MyDrinkServiceImpl myDrinkServiceImpl;


}
