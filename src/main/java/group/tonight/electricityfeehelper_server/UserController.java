package group.tonight.electricityfeehelper_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    public UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<User> list() {
        return userJPA.findAll();
    }

}
