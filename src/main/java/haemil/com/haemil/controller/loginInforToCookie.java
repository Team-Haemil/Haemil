package haemil.com.haemil.controller;

import haemil.com.haemil.service.AuthService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class loginInforToCookie {
    @GetMapping("/login-success")
    public View loginSuccess(@AuthenticationPrincipal OAuth2User oauth2User){
        AuthService authService = new AuthService();
        String email = (String) oauth2User.getAttributes().get("email");

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");

        return redirectView;
    }
}
