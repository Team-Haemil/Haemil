package haemil.com.haemil.controller;

import haemil.com.haemil.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/v1/tokens")
public class AuthController{
    private final AuthService authservice;

    @Autowired
    public AuthController(AuthService authservice){
        this.authservice = authservice;
    }

    @GetMapping("/{authprovider}")
    public String login(@PathVariable int authProvider){
        return authservice.loginWithProvider(authProvider);
    }
}
