package haemil.com.haemil.controller;

import haemil.com.haemil.domain.SettingUserId;
import haemil.com.haemil.domain.settingCookies;
import jakarta.servlet.http.HttpServletResponse;

public class cookieController {

    settingCookies settingCookies = new settingCookies();
    SettingUserId settingUserId = new SettingUserId();

    public void sendCookie(String email, HttpServletResponse response){
        email = email.split("@")[0];
        String sendNameEmail = "user_for_" + email.split("@")[0];
        String userId = settingUserId.setUserId4().toString();
        String userInfo = "email="+email+"&id="+userId;
        settingCookies.setCookie(sendNameEmail, response, userInfo);

    }
}

/*
                    userId = settingUserId.setUserId4().toString();
                    String userInfo = "email=" + email + "&id=" + userId;
                    String cookieUserId = "user_for_"+email.split("@")[0];
                    settingCookies.setCookie(cookieUserId, response, userInfo);
 */