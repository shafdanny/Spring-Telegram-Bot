package spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shafiq on 28/01/16.
 */

@RestController
public class Controller {

    @RequestMapping("/helloworld")
    public String helloworld(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello, " + name + "!";
    }
}
