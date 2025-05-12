package haemil.com.haemil.service;

import org.springframework.stereotype.Service;

import java.security.AuthProvider;

@Service
public class AuthService {
    public String loginType;
    public String loginWithProvider(int provider){
        switch (provider) {
            case 1:
                return googleLogin();
            default:
                throw new UnsupportedOperationException("Provider not supported");
        }
    }

    private String googleLogin() {
        String googleUrl = "https://accounts.google.com/o/oauth2/v2/auth" +
                            "?client_id=YOUR_GOOGLE_CLIENT_ID" +
                            "&redirect_uri=http://localhost:8080/login/oauth2/code/google" +
                            "&response_type=code" +
                            "&scope=openid%20profile%20email";
        return "redirect" + googleUrl;
    }

}
