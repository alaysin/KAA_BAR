package level.up.kaabar.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/stuff")
public class MyUserController {

    @Autowired
    MyUserService myUserService;


}
