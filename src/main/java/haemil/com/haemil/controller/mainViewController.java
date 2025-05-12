package haemil.com.haemil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainViewController {

    @RequestMapping("/")
    public String mainView() {
        return "haemil";
    }
}