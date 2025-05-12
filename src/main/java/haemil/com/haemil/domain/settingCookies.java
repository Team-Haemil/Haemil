package haemil.com.haemil.domain;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class settingCookies {

    public void setCookie(String name, HttpServletResponse response, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24 * 365); // 우선 1년
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        response.addCookie(cookie);
    }

    public String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "No_cookie";
    }
}