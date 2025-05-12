package haemil.com.haemil.controller;

import haemil.com.haemil.domain.SettingUserId;
import haemil.com.haemil.domain.settingCookies;
import haemil.com.haemil.service.AuthService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@RestController
public class loginInforToCookie {
    SettingUserId settingUserId = new SettingUserId();
    settingCookies settingCookies = new settingCookies();
    cookieController cookieController = new cookieController();
    String userInfo;

    @GetMapping("/login-success")
    public View loginSuccess(@AuthenticationPrincipal OAuth2User oauth2User, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        AuthService authService = new AuthService();

        String email = null;
        String userId = null;
        String RequestId = "user_for_" + oauth2User.getAttribute("email").toString().split("@")[0];
        String getUserIdResult = settingCookies.getCookie(request, RequestId);

        if(!getUserIdResult.equals("No_cookie")) {
            email = getUserIdResult.split("&")[0].split("=")[1];
            if (email.equals(oauth2User.getAttribute("email").toString().split("@")[0])){
                System.out.println("이메일이 있습니다. id만 받아오기");
                userId = getUserIdResult.split("&")[1].split("=")[1];
            } else {
                System.out.println("새 계정으로 로그인되었습니다.");
                cookieController.sendCookie(oauth2User.getAttribute("email"), response);
            }
        } else {
            System.out.println("처음 방문이시군요!");
            email = oauth2User.getAttribute("email");
            cookieController.sendCookie(email, response);
        }

        System.out.println("email : " + email + " userId : " + userId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");

        return redirectView;
    }
}







/*
        if (!getUserIdResult.equals("No_cookie")) {
            if (getUserIdResult.split("&").length == 2) {
                String userInfoArray1 = getUserIdResult.split("&")[0]; //이메일용
                String userInfoArray2 = getUserIdResult.split("&")[1]; //아이디용

                email = userInfoArray1.split("=")[1].split("@")[0];
                String receEmail = oauth2User.getAttribute("email");
                receEmail = receEmail.split("@")[0];

                if (email.equals(receEmail)) { //이미 방문한 유저일 때
                    userId = userInfoArray2.split("=")[1];
                } else { //쿠키가 있지만 새로운 계정으로 로그인했을 때
                    userId = settingUserId.setUserId4().toString();
                    String userInfo = "email=" + email + "&id=" + userId;
                    String cookieUserId = "user_for_"+email.split("@")[0];
                    settingCookies.setCookie(cookieUserId, response, userInfo);
                }
            } else { //완전 처음 방문일 때
                email = oauth2User.getAttribute("email");
                userId = settingUserId.setUserId4().toString();
                String userInfo = "email=" + email + "&id=" + userId;
                String cookieUserId = "user_for_"+email.split("@")[0];
                settingCookies.setCookie(cookieUserId, response, userInfo);
            }

        } else {
            email = oauth2User.getAttribute("email");
            userId = settingUserId.setUserId4().toString();
            String userInfo = "email=" + email + "&id=" + userId;
            String cookieUserId = "user_for_"+email.split("@")[0];
            settingCookies.setCookie(cookieUserId, response, userInfo);
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");

        System.out.println("email : " + email + " userId : " + userId);

        return redirectView;
    }
}
*/